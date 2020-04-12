@ def traverse(v: ujson.Value): Iterable[String] = v match{
    case a: ujson.Arr => a.arr.flatMap(traverse)
    case o: ujson.Obj => o.obj.values.flatMap(traverse)
    case s: ujson.Str => Seq(s.str)
    case _ => Nil
  }

@ traverse(data)
res45: Iterable[String] = ArrayBuffer(
  "https://api.github.com/repos/.../releases/17991367",
  "https://api.github.com/repos/.../releases/17991367/assets",
  "https://uploads.github.com/repos/.../releases/17991367/assets",
  "https://github.com/.../releases/tag/1.6.8",
...
