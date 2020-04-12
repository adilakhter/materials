@ val m = Map("one" -> 1, "two" -> 2, "three" -> 3)
m: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

@ m.get("one")
res27: Option[Int] = Some(1)

@ m.get("four")
res28: Option[Int] = None
