@ data(0)
res3: ujson.Value = Obj(
  LinkedHashMap(
    "url" -> Str("https://api.github.com/repos/.../releases/17991367"),
    "assets_url" -> Str("https://api.github.com/repos/.../releases/17991367/assets"),
...

@ data(0)("url")
res4: ujson.Value = Str("https://api.github.com/repos/.../releases/17991367")

@ data(0)("author")("id")
res5: ujson.Value = Num(2.0607116E7)
