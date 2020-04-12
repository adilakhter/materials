 def evaluate(expr: Expr, scope: Map[String, Value]): Value = expr match{
   ...
   case Expr.Call(expr, args) =>
     val Value.Func(call) = evaluate(expr, scope)
     val evaluatedArgs = args.map(evaluate(_, scope))
     call(evaluatedArgs)
+  case Expr.Func(argNames, body) =>
+    Value.Func(args => evaluate(body, scope ++ argNames.zip(args)))
 }
