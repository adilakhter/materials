@ import $file.Arithmetic, Arithmetic.parser

@ fastparse.parse("(one plus two) times ((three plus four) times five)", parser(_))
res5: Parsed[Int] = Success(105, 51)

@ fastparse.parse("(two plus ten) times seven", parser(_))
res7: Parsed[Int] = Parsed.Failure(Position 1:1, found "(two plus ")
