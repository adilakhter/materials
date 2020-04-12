@ def parser[_: P] = P( ("hello" | "goodbye") ~ " ".rep(1) ~ ("world" | "seattle") ~ End )

@ fastparse.parse("hello world", parser(_))
res36: Parsed[Unit] = Success((), 11)

@ fastparse.parse("hello     world", parser(_))
res37: Parsed[Unit] = Success((), 15)

@ fastparse.parse("helloworld", parser(_))
res38: Parsed[Unit] = Parsed.Failure(Position 1:6, found "world")
