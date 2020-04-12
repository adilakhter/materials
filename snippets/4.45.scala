@ val m = collection.mutable.Map("one" -> 1, "two" -> 2, "three" -> 3)

@ m.getOrElseUpdate("three", -1) // already present, returns existing value
res31: Int = 3

@ m // `m` is unchanged
res32: mutable.Map[String, Int] = HashMap("two" -> 2, "three" -> 3, "one" -> 1)

@ m.getOrElseUpdate("four", -1) // not present, stores new value in map and returns it
res33: Int = -1

@ m // `m` now contains "four" -> -1
res34: mutable.Map[String, Int] = HashMap(
  "two" -> 2,
  "three" -> 3,
  "four" -> -1,
  "one" -> 1
)
