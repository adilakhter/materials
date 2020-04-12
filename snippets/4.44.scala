@ val m = collection.mutable.Map("one" -> 1, "two" -> 2, "three" -> 3)
m: mutable.Map[String, Int] = HashMap("two" -> 2, "three" -> 3, "one" -> 1)

@ m.remove("two")
res263: Option[Int] = Some(2)

@ m("five") = 5

@ m
res265: mutable.Map[String, Int] = HashMap("five" -> 5, "three" -> 3, "one" -> 1)
