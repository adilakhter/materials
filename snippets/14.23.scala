// app/src/MinimalApplication.scala
   )
+
+  def messageList() = frag(for((name, msg) <- messages) yield p(b(name), " ", msg))
+
   @cask.postForm("/")
