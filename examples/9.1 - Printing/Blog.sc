// Blog.sc
val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix.stripSuffix(".md"), p)
  }
  .sortBy(_._1.toInt)

// Usage
assert(
  pprint.log(postInfo.map(t => (t._1, t._2))) ==
  Seq("1" -> "My First Post", "2" -> "My Second Post", "3" -> "My Third Post")
)