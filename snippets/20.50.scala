@ evaluate(
    fastparse.parse(
      """local f = function(a, b) a + " " + b; f("hello", "world")""",
      Parser.expr(_)
    ).get.value,
    Map.empty
  )
res119: Value = Str("hello world")
