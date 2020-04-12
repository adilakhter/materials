@ evaluate(
    fastparse.parse("""local greeting = "Hello "; greeting + greeting""", Parser.expr(_))
      .get.value,
    Map.empty
  )
res94: Value = Str("Hello Hello ")
