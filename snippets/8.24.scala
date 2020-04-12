@ {
  case class Uploader(id: Int, login: String, `type`: java.io.PrintStream)
  implicit val uploaderRw = upickle.default.macroRW[Uploader]
  }
cmd2.sc:2: could not find implicit value for parameter
           e: upickle.default.Reader[java.io.PrintStream]
  implicit val uploaderRw = upickle.default.macroRW[Uploader]
                                                   ^
Compilation Failed
