@ fastparse.parse("hello universe", parser(_)) // Not "world" or "seattle"
res30: Parsed[Unit] = Parsed.Failure(Position 1:7, found "universe")

@ fastparse.parse("helloworld", parser(_)) // Missing the single " " blank space
res31: Parsed[Unit] = Parsed.Failure(Position 1:6, found "world")

@ fastparse.parse("hello  world", parser(_)) // Too many blank spaces
res32: Parsed[Unit] = Parsed.Failure(Position 1:7, found " world")

@ fastparse.parse("i love seattle", parser(_)) // Not a hello or goodbye
res33: Parsed[Unit] = Parsed.Failure(Position 1:1, found "i love sea")

@ fastparse.parse("hello seattle moo", parser(_)) // Did not consume entire string
res34: Parsed[Unit] = Parsed.Failure(Position 1:14, found " moo")
