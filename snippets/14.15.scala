// app/src/MinimalApplication.scala
   def postHello(name: String, msg: String) = {
-    messages = messages :+ (name -> msg)
+    if (name != "" && msg != "") messages = messages :+ (name -> msg)
     hello()
   }
