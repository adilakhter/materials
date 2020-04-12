 def evaluate(expr: Expr, scope: Map[String, Value]): Value = expr match{
   ...
+  case Expr.Local(name, assigned, body) =>
+    val assignedValue = evaluate(assigned, scope)
+    evaluate(body, scope + (name -> assignedValue))
 }
