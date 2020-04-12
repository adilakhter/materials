// app/src/MinimalApplication.scala
-  @cask.postForm("/")
+  @cask.postJson("/")
   def postHello(name: String, msg: String) = {
-    if (name == "") hello(Some("Name cannot be empty"), Some(name), Some(msg))
+    if (name == "") ujson.Obj("success" -> false, "err" -> "Name cannot be empty")
-    else if (msg == "") hello(Some("Message cannot be empty"), Some(name), Some(msg))
+    else if (msg == "") ujson.Obj("success" -> false, "err" -> "Message cannot be empty")
     else {
       messages = messages :+ (name -> msg)
-      hello(None, Some(name), None)
+      ujson.Obj("success" -> true, "txt" -> messageList().render, "err" -> "")
     }
   }
