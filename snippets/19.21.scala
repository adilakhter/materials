@ val Parsed.Success(result, index) = fastparse.parse("goodbye   seattle", parser(_))
result: Phrase = Phrase(false, "seattle")
index: Int = 17

@ result.isHello
res48: Boolean = false

@ result.place
res49: String = "seattle"
