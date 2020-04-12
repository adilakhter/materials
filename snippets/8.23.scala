@ {
  case class Uploader(id: Int, login: String, `type`: String)
  implicit val uploaderRw = upickle.default.macroRW[Uploader]
  case class Asset(id: Int, name: String, uploader: Uploader)
  implicit val assetRw = upickle.default.macroRW[Asset]
  }

@ val assets = upickle.default.read[Seq[Asset]](data(0)("assets"))
assets: Seq[Asset] = List(
  Asset(13194960, "2.12-1.6.8", Uploader(20607116, "Ammonite-Bot", "User")),
  Asset(13194961, "2.13-1.6.8", Uploader(20607116, "Ammonite-Bot", "User")),
  Asset(13199400, "2.12-1.6.8-1-c7a656e", Uploader(20607116, "Ammonite-Bot", "User")),
...

@ println(upickle.default.write(assets, indent=4))
[
    {
        "id": 13194960,
        "name": "2.12-1.6.8",
        "uploader": {
            "id": 20607116,
            "login": "Ammonite-Bot",
            "type": "User"
        }
    },
    {
...
