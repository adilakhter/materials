@ data(0).obj
res6: collection.mutable.LinkedHashMap[String, ujson.Value] = LinkedHashMap(
  "url" -> Str("https://api.github.com/repos/.../releases/17991367"),
  "assets_url" -> Str("https://api.github.com/repos/.../releases/17991367/assets"),
...

@ data(0).obj.keys
res7: Iterable[String] = Set(
  "url",
  "assets_url",
  "upload_url",
...

@ data(0).obj.size
res8: Int = 18
