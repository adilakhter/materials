@ shortestPath(
    start = "a",
    dest = "c",
    graph = Map(
      "a" -> Seq("b", "c"),
      "b" -> Seq("c", "d"),
      "c" -> Seq("d"),
      "d" -> Seq()
    )
  )
res66: Seq[String] = List("a", "c")
