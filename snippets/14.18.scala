// app/src/MinimalApplication.scala
+          for(error <- errorOpt) yield i(color.red)(error),
           form(action := "/", method := "post")(
