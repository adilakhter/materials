// Lookup.sc
val output = ujson.Arr(
  ujson.Obj("hello" -> "world", "answer" -> 42),
  true
)

println(output)

output(0)("hello") = "goodbye"

output(0)("tags") = ujson.Arr("awesome", "yay", "wonderful")

assert(
  pprint.log(ujson.write(output)) ==
  """[{"hello":"goodbye","answer":42,"tags":["awesome","yay","wonderful"]},true]"""
)

output(0).obj.remove("hello")

assert(
  pprint.log(ujson.write(output)) ==
  """[{"answer":42,"tags":["awesome","yay","wonderful"]},true]"""
)

output.arr.append(123)

assert(
  pprint.log(ujson.write(output)) ==
  """[{"answer":42,"tags":["awesome","yay","wonderful"]},true,123]"""
)

output.arr.clear()

assert(pprint.log(ujson.write(output)) == "[]")