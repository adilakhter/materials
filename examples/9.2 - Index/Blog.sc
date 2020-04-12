// Blog.sc
import $ivy.`com.lihaoyi::scalatags:0.8.4`, scalatags.Text.all._

val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix.stripSuffix(".md"), p)
  }
  .sortBy(_._1.toInt)


os.remove.all(os.pwd / "out")
os.makeDir.all(os.pwd / "out" / "post")

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
val indexHtml = pprint.log(os.read(os.pwd / "out" / "index.html"))
assert(indexHtml.contains("<h2>My First Post</h2>"))
assert(indexHtml.contains("<h2>My Second Post</h2>"))
assert(indexHtml.contains("<h2>My Third Post</h2>"))