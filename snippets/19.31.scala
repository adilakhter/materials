@ fastparse.parse("seven", number(_))
res72: Parsed[Int] = Success(7, 5)

@ fastparse.parse("zero", number(_))
res73: Parsed[Int] = Success(0, 4)

@ fastparse.parse("lol", number(_))
res74: Parsed[Int] = Parsed.Failure(Position 1:1, found "lol")
