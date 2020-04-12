// Blog.sc
val postInfo = os
  .list(os.pwd / "post")
  .map{ p =>
    val Array(prefix, suffix) = p.last.split(" - ")
    (prefix, suffix, p)
  }
  .sortBy(_._1.toInt)

println("POSTS")
postInfo.foreach(println)
