import $ivy.`com.atlassian.commonmark:commonmark:0.13.1`
import $ivy.`com.lihaoyi::scalatags:0.8.4`, scalatags.Text.all._
import mill._

def mdNameToHtml(name: String) = {
  name.stripSuffix(".md").replace(" ", "-").toLowerCase + ".html"
}
def renderMarkdown(s: String) = {
  val parser = org.commonmark.parser.Parser.builder().build()
  val document = parser.parse(s)
  val renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build()
  renderer.render(document)
}
def renderHtmlPage(dest: os.Path, bootstrapUrl: String, contents: Frag*) = {
  os.write(
    dest,
    doctype("html")(
      html(head(link(rel := "stylesheet", href := bootstrapUrl)), body(contents))
    )
  )
  PathRef(dest)
}

def bootstrap = T{
  os.write(
    T.dest / "bootstrap.css",
    requests.get("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css")
      .text()
  )
  PathRef(T.dest / "bootstrap.css")
}

val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix, p)
  }
  .sortBy(_._1.toInt)

interp.watch(os.pwd / "post")

object post extends Cross[PostModule](postInfo.map(_._1):_*)
class PostModule(number: String) extends Module{
  val Some((_, suffix, markdownPath)) = postInfo.find(_._1 == number)
  def path = T.source(markdownPath)
  def preview = T{
    renderMarkdown(os.read.lines(path().path).takeWhile(_.nonEmpty).mkString("\n"))
  }
  def render = T{
    renderHtmlPage(
      T.dest / mdNameToHtml(suffix),
      "../bootstrap.css",
      h1(a(href := "../index.html")("Blog"), " / ", suffix.stripSuffix(".md")),
      raw(renderMarkdown(os.read(path().path)))
    )
  }
}

def links = T.input{ postInfo.map(_._2) }
val posts = T.sequence(postInfo.map(_._1).map(post(_).render))
val previews = T.sequence(postInfo.map(_._1).map(post(_).preview))

def index = T {
  renderHtmlPage(
    T.dest / "index.html",
    "bootstrap.css",
    h1("Blog"),
    for ((suffix, preview) <- links().zip(previews()))
      yield frag(
        h2(a(href := ("post/" + mdNameToHtml(suffix)))(suffix)),
        raw(preview) // include markdown-generated HTML "raw" without HTML-escaping it
      )
  )
}

def dist = T {
  for (post <- posts()) {
    os.copy(post.path, T.dest / "post" / post.path.last, createFolders = true)
  }
  os.copy(index().path, T.dest / "index.html")
  os.copy(bootstrap().path, T.dest / "bootstrap.css")
  PathRef(T.dest)
}
