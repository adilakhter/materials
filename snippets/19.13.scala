@ fastparse.parse("hello world", parser(_))
res12: Parsed[Unit] = Success((), 11)

@ fastparse.parse("hello seattle", parser(_))
res13: Parsed[Unit] = Success((), 13)

@ fastparse.parse("goodbye world", parser(_))
res14: Parsed[Unit] = Success((), 13)
