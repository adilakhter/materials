@ fastparse.parse("""{"a": "b", "cde": id}""", expr(_))
res85: Parsed[Expr] = Success(Dict(Map("a" -> Str("b"), "cde" -> Ident("id"))), 21)

@ fastparse.parse("""{"a": "b", "cde": id, "nested": {}}""", expr(_))
res86: Parsed[Expr] = Success(
  Dict(Map("a" -> Str("b"), "cde" -> Ident("id"), "nested" -> Dict(Map()))),
  35
)
