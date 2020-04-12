def evaluate(expr: Expr, scope: Map[String, Value]): Value = expr match{
  case Expr.Str(s) => Value.Str(s)
  case Expr.Dict(kvs) => Value.Dict(kvs.map{case (k, v) => (k, evaluate(v, scope))})
  case Expr.Plus(left, right) =>
    val Value.Str(leftStr) = evaluate(left, scope)
    val Value.Str(rightStr) = evaluate(right, scope)
    Value.Str(leftStr + rightStr)
  case Expr.Local(name, assigned, body) =>
    val assignedValue = evaluate(assigned, scope)
    evaluate(body, scope + (name -> assignedValue))
  case Expr.Ident(name) => scope(name)
}
