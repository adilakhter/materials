@ evaluate(fastparse.parse("\"hello\" + \"world\"", Parser.expr(_)).get.value, Map.empty)
res5: Value = Str("helloworld")
