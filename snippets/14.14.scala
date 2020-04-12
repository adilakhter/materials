// app/src/MinimalApplication.scala
-  @cask.post("/do-thing")
-  def doThing(request: cask.Request) = {
-    request.text().reverse
-  }
+  @cask.postForm("/")
+  def postHello(name: String, msg: String) = {
+    messages = messages :+ (name -> msg)
+    hello()
+  }
