@ def str[_: P] = P( "\"" ~~/ CharsWhile(_ != '"', 0).! ~~ "\"" ).map(Expr.Str)

@ fastparse.parse("\"hello\"", str(_))
res10: Parsed[Str] = Success(Str("hello"), 7)

@ fastparse.parse("\"hello world\"", str(_))
res11: Parsed[Str] = Success(Str("hello world"), 13)

@ fastparse.parse("\"\"", str(_))
res12: Parsed[Str] = Success(Str(""), 2)

@ fastparse.parse("123", str(_))
res13: Parsed[Str] = Parsed.Failure(Position 1:1, found "123")
