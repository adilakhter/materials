@ case class Asset(id: Int, name: String)

@ implicit val assetRw = upickle.default.macroRW[Asset]

@ upickle.default.read[Seq[Asset]](data(0)("assets"))
res81: Seq[Asset] = List(
  Asset(13194960, "2.12-1.6.8"),
  Asset(13194961, "2.13-1.6.8"),
  Asset(13199400, "2.12-1.6.8-1-c7a656e"),
...
