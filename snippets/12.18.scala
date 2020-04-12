@ {
  val issueNumMap = issueData
    .sortBy(_._1)
    .map(_._1)
    .zipWithIndex
    .toMap
    // +1 because issues start from #1, rather than #0
    // +1 because we created a single issue earlier, so subsequent issues are offset by 1
    .map{case (k, v) => (k, v + 1 + 1)}
  }
issueNumMap: Map[Int, Int] = Map(
  101 -> 118,
  88 -> 127,
  170 -> 66,
...
