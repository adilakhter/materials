@ fastparse.parse(
    """local thing = "kay"; {"a": "A", "f": function(a) a + a, "nested": {"k": v}}""",
    Parser.expr(_)
  )
res74: Parsed[Expr] = Success(
  Local(
    "thing",
    Str("kay"),
    Dict(
      Map(
        "a" -> Str("A"),
        "f" -> Func(List("a"), Plus(Ident("a"), Ident("a"))),
        "nested" -> Dict(Map("k" -> Ident("v")))
      )
    )
  ),
  85
)
