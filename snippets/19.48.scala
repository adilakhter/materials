@ fastparse.parse("(two plus ten) times seven", parser(_))
res14: Parsed[Int] = Parsed.Failure(Position 1:11, found "ten) times")
