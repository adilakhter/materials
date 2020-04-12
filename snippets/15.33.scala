@ ctx.transaction{
    ctx.run(
      query[City].filter(_.district == "Test Borough").update(_.district -> "Test County")
    )
    throw new Exception()
  }
cmd46.sc:2: UPDATE city SET district = 'Test County' WHERE district = 'Test Borough'
java.lang.Exception
  ammonite.$sess.cmd46$.$anonfun$res46$1(cmd46.sc:3)
  io.getquill.context.jdbc.JdbcContext.$anonfun$transaction$2(JdbcContext.scala:81)
...

@ ctx.run(query[City].filter(_.population == 0))
res47: List[City] = List(
  City(10001, "testville", "TSV", "Test Borough", 0),
  City(10002, "testopolis", "TSO", "Test Borough", 0),
  City(10003, "testberg", "TSB", "Test Borough", 0),
  City(10000, "testford", "TST", "Test Borough", 0)
)
