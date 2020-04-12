// SerializationAssets.sc
val jsonString = os.read(os.pwd / "ammonite-releases.json")

val data = ujson.read(jsonString)

pprint.log(ujson.write(data(0)("assets"), indent = 4), height = 20)

case class Asset(id: Int, name: String)

implicit val assetRw = upickle.default.macroRW[Asset]

val assets = upickle.default.read[Seq[Asset]](data(0)("assets"))

assert(
  pprint.log(assets) ==
  List(
    Asset(13194960, "2.12-1.6.8"),
    Asset(13194961, "2.13-1.6.8"),
    Asset(13199400, "2.12-1.6.8-1-c7a656e"),
    Asset(13199401, "2.13-1.6.8-1-c7a656e"),
    Asset(13220957, "2.12-1.6.8-2-0a2abd6"),
    Asset(13220958, "2.13-1.6.8-2-0a2abd6"),
    Asset(13240877, "2.12-1.6.8-3-3634218"),
    Asset(13240878, "2.13-1.6.8-3-3634218")
  )
)

pprint.log(upickle.default.write(assets, indent = 4), height = 20)
