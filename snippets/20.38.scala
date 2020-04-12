@ evaluate(
    fastparse.parse("""{"hello": "world", "key": "value"}""", Parser.expr(_)).get.value,
    Map.empty
  )
res81: Value = Dict(Map("hello" -> Str("world"), "key" -> Str("value")))
