@ fastparse.parse("a + b", expr(_))
res65: Parsed[Expr] = Success(Plus(Ident("a"), Ident("b")), 5)

@ fastparse.parse("a + b + c", expr(_))
res66: Parsed[Expr] = Success(Plus(Plus(Ident("a"), Ident("b")), Ident("c")), 9)

@ fastparse.parse("""a + " " + c""", expr(_))
res67: Parsed[Expr] = Success(Plus(Plus(Ident("a"), Str(" ")), Ident("c")), 11)
