@ evaluate(
    fastparse.parse("""local x = "Hello "; local y = "world"; x + y""", Parser.expr(_))
      .get.value,
    Map.empty
  )
res96: Value = Str("Hello world")
