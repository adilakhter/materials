// Lookup.sc
val jsonString = os.read(os.pwd / "ammonite-releases.json")

val data = ujson.read(jsonString)

pprint.log(data(0), height = 20)

assert(
  pprint.log(data(0)("url")) ==
  ujson.Str("https://api.github.com/repos/lihaoyi/Ammonite/releases/17991367")
)

assert(pprint.log(data(0)("author")("id")) == ujson.Num(20607116))

pprint.log(data(0).obj, height = 20)

pprint.log(data(0).obj.keys, height = 20)

assert(pprint.log(data(0).obj.size) == 18)

assert(pprint.log(data(0)("url").str) == "https://api.github.com/repos/lihaoyi/Ammonite/releases/17991367")

assert(pprint.log(data(0)("author")("id").num) == 20607116)

assert(pprint.log(data(0)("author")("id").num.toInt) == 20607116)