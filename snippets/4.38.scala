@ Vector(("one", 1), ("two", 2), ("three", 3)).to(Map)
res224: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

@ Map[String, Int]() + ("one" -> 1) + ("three" -> 3)
res225: Map[String, Int] = Map("one" -> 1, "three" -> 3)

@ for((k, v) <- m) println(k + " " + v)
one 1
two 2
three 3
