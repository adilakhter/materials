@ fastparse.parse(
    """local greeting = "Hello ";greeting + greeting""",
    Parser.expr(_)
  )
res85: Parsed[Expr] = Success(
  Local("greeting", Str("Hello "), Plus(Ident("greeting"), Ident("greeting"))),
  45
)
