@ ctx.run(query[City].filter(_.id == 10000).update(_.name -> "testford"))
cmd42.sc:1: UPDATE city SET name = 'testford' WHERE id = 10000
res42: Long = 1L

@ ctx.run(query[City].filter(_.id == 10000))
res43: List[City] = List(City(10000, "testford", "TST", "Test County", 0))
