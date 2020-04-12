@ fastparse.parse("hello     world", parser(_))
res40: Parsed[Unit] = Success((), 15)

@ fastparse.parse("hello", parser(_))
res41: Parsed[Unit] = Success((), 5)
