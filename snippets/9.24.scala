// Blog.sc
import $ivy.`com.lihaoyi::scalatags:0.8.4`, scalatags.Text.all._
import $ivy.`com.atlassian.commonmark:commonmark:0.13.1`

val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix, p)
  }
  .sortBy(_._1.toInt)

def mdNameToHtml(name: String) = {
  name.stripSuffix(".md").replace(" ", "-").toLowerCase + ".html"
}

val bootstrapCss = link(
  rel := "stylesheet",
  href := "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css"
)

os.remove.all(os.pwd / "out")
os.makeDir.all(os.pwd / "out" / "post")
for((_, suffix, path) <- postInfo) {
  val parser = org.commonmark.parser.Parser.builder().build()
  val document = parser.parse(os.read(path))
  val renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build()
  val output = renderer.render(document)
  os.write(
    os.pwd / "out" / "post" / mdNameToHtml(suffix),
    doctype("html")(
      html(
        head(bootstrapCss),
        body(
          h1(a(href := "../index.html")("Blog"), " / ", suffix.stripSuffix(".md")),
          raw(output)
        )
      )
    )
  )
}

os.write(
  os.pwd / "out" / "index.html",
  doctype("html")(
    html(
      head(bootstrapCss),
      body(
        h1("Blog"),
        for((_, suffix, _) <- postInfo)
        yield h2(a(href := ("post/" + mdNameToHtml(suffix)))(suffix))
      )
    )
  )
)
