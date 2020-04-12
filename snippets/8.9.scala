@ val output = ujson.Arr(
    ujson.Obj("hello" -> ujson.Str("world"), "answer" -> ujson.Num(42)),
    ujson.Bool(true)
  )
output: ujson.Arr = Arr(
  ArrayBuffer(Obj(LinkedHashMap("hello" -> Str("world"), "answer" -> Num(42.0))), true)
)
