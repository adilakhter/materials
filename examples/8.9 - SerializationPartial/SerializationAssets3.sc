// SerializationAssets3.sc
val jsonString = os.read(os.pwd / "ammonite-releases.json")

val data = ujson.read(jsonString)

case class Asset3(id: Int, name: String, uploader: ujson.Value)

implicit val asset3Rw = upickle.default.macroRW[Asset3]

val assets3 = upickle.default.read[Seq[Asset3]](data(0)("assets"))

pprint.log(assets3, height = 100)