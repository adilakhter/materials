// app/src/MinimalApplication.scala
-          form(action := "/", method := "post")(
+          form(onsubmit := "submitForm(); return false")(
