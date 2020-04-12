// Blog.sc
import $ivy.`com.lihaoyi::scalatags:0.8.4`, scalatags.Text.all._
import $ivy.`com.atlassian.commonmark:commonmark:0.13.1`

val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix.stripSuffix(".md"), p)
  }
  .sortBy(_._1.toInt)

def mdNameToHtml(name: String) = name.replace(" ", "-").toLowerCase + ".html"

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
        body(
          h1(a("Blog", href := "../index.html"), " / ", suffix),
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
      body(
        h1("Blog"),
        for((_, suffix, _) <- postInfo)
        yield h2(suffix)
      )
    )
  )
)

// Usage
assert(pprint.log(os.read(os.pwd / "out" / "post" / "my-first-post.html")).contains(" / My First Post</h1>"))
assert(pprint.log(os.read(os.pwd / "out" / "post" / "my-second-post.html")).contains(" / My Second Post</h1>"))
assert(pprint.log(os.read(os.pwd / "out" / "post" / "my-Third-post.html")).contains(" / My Third Post</h1>"))