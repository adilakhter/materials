@ ctx.run(query[City].insert(City(10000, "test", "TST", "Test County", 0)))
cmd36.sc:1: INSERT INTO city (id,name,countrycode,district,population)
            VALUES (10000, 'test', 'TST', 'Test County', 0)
res36: Long = 1L

@ ctx.run(query[City].filter(_.population == 0))
res37: List[City] = List(City(10000, "test", "TST", "Test County", 0))
