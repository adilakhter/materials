@ def findName(cityId: Int) = ctx.run(
    query[City].filter(_.id == lift(cityId)).map(_.name)
  )
cmd32.sc:1: SELECT x1.name FROM city x1 WHERE x1.id = ?

@ findName(3208)
res33: List[String] = List("Singapore")

@ findName(3209)
res34: List[String] = List("Bratislava")
