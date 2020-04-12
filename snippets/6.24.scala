@ search(
    start = "c",
    graph = Map(
      "a" -> Seq("b", "c"),
      "b" -> Seq("a"),
      "c" -> Seq("b")
    )
  )
res45: Set[String] = Set("a", "b", "c")
