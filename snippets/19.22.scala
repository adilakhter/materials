@ val Parsed.Success(Phrase(isHello, place), index) =
    fastparse.parse("goodbye   seattle", parser(_))
isHello: Boolean = false
place: String = "seattle"
index: Int = 17
