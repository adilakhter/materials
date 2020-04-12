// SerializationAssets2.sc
val jsonString = os.read(os.pwd / "ammonite-releases.json")

val data = ujson.read(jsonString)

case class Uploader(id: Int, login: String, `type`: String)

case class Asset2(id: Int, name: String, uploader: Uploader)

implicit val uploaderRw = upickle.default.macroRW[Uploader]

implicit val asset2Rw = upickle.default.macroRW[Asset2]

val assets2 = upickle.default.read[Seq[Asset2]](data(0)("assets"))
assert(
  pprint.log(assets2) ==
  List(
    Asset2(13194960, "2.12-1.6.8", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13194961, "2.13-1.6.8", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13199400, "2.12-1.6.8-1-c7a656e", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13199401, "2.13-1.6.8-1-c7a656e", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13220957, "2.12-1.6.8-2-0a2abd6", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13220958, "2.13-1.6.8-2-0a2abd6", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13240877, "2.12-1.6.8-3-3634218", Uploader(20607116, "Ammonite-Bot", "User")),
    Asset2(13240878, "2.13-1.6.8-3-3634218", Uploader(20607116, "Ammonite-Bot", "User"))
  )
)

pprint.log(upickle.default.write(assets2, indent = 4), height = 20)
