@ val smallExpr = BinOp(Variable("x"), "+", Literal(1))

@ val largeExpr = BinOp(
    BinOp(Variable("x"), "+", Literal(1)),
    "*",
    BinOp(Variable("y"), "-", Literal(1))
  )

@ stringify(smallExpr)
res7: String = "(x + 1)"

@ stringify(largeExpr)
res8: String = "((x + 1) * (y - 1))"
