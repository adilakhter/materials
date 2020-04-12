// build.sc
import $ivy.`com.lihaoyi::scalatags:0.8.4`, scalatags.Text.all._
import $ivy.`com.atlassian.commonmark:commonmark:0.13.1`
import mill._


val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix.stripSuffix(".md"), p)
  }
  .sortBy(_._1.toInt)

def mdNameToHtml(name: String) = name.stripSuffix(".md").replace(" ", "-").toLowerCase + ".html"

val bootstrapCss = link(
  rel := "stylesheet",
  href := "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
)

interp.watch(os.pwd / "post")

object post extends Cross[PostModule](postInfo.map(_._1):_*)
class PostModule(number: String) extends Module{
  val Some((_, suffix, path)) = postInfo.find(_._1 == number)
  def srcPath = T.source(path)
  def render = T{
    val parser = org.commonmark.parser.Parser.builder().build()
    val document = parser.parse(os.read(srcPath().path))
    val renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build()
    val output = renderer.render(document)
    os.write(
      T.dest /  mdNameToHtml(suffix),
      doctype("html")(
        html(
          head(bootstrapCss),
          body(
            h1(a("Blog", href := "../index.html"), " / ", suffix.stripSuffix(".md")),
            raw(output)
          )
        )
      )
    )
    PathRef(T.dest / mdNameToHtml(suffix))
  }
}

def links = T.input{ postInfo.map(_._2) }

def index = T{
  os.write(
    T.dest / "index.html",
    doctype("html")(
      html(
        head(bootstrapCss),
        body(
          h1("Blog"),
          for (suffix <- links())
          yield h2(a(suffix, href := ("post/" + mdNameToHtml(suffix))))
        )
      )
    )
  )
  PathRef(T.dest / "index.html")
}

val posts = T.sequence(postInfo.map(_._1).map(post(_).render))

def dist = T {
  for (post <- posts()) {
    os.copy(post.path, T.dest / "post" / post.path.last, createFolders = true)
  }
  os.copy(index().path, T.dest / "index.html")
  PathRef(T.dest)
}
