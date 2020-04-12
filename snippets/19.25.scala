@ val Parsed.Success(result, index) = fastparse.parse("goodbye   world", parser(_))
result: Phrase = Phrase(false, "world")
index: Int = 15

@ result.place
res54: String = "world"

@ fastparse.parse("goodbyeseattle", parser(_))
res55: Parsed[Phrase] = Parsed.Failure(Position 1:8, found "seattle")
