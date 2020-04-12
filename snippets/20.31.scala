@ fastparse.parse("\"123\"", Parser.expr(_))
res63: Parsed[Expr] = Success(Str("123"), 5)

@ fastparse.parse("a + b + c", Parser.expr(_))
res66: Parsed[Expr] = Success(Plus(Ident("a"), Plus(Ident("b"), Ident("c"))), 9)

@ fastparse.parse("""{"a": "A", "b": "bee"}""", Parser.expr(_))
res69: Parsed[Expr] = Success(Dict(Map("a" -> Str("A"), "b" -> Str("bee"))), 22)

@ fastparse.parse("""f()(a) + g(b, c)""", Parser.expr(_))
res95: Parsed[Expr] = Success(
  Plus(
    List(
      Call(Call(Ident("f"), List()), List(Ident("a"))),
      Call(Ident("g"), List(Ident("b"), Ident("c")))
    )
  ),
  16
)
