@ val m = Map("one" -> 1, "two" -> 2, "three" -> 3)
m: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

@ m.contains("two")
res218: Boolean = true

@ m("two")
res219: Int = 2

@ m.contains("four")
res220: Boolean = false
