   def main(args: Array[String]): Unit = {
     ...
     def callAgent[T: upickle.default.Reader](rpc: Rpc): T = {
       Shared.send(agent.stdin.data, rpc)
       Shared.receive[T](agent.stdout.data)
     }
+    val subPaths = os.walk(src).map(_.subRelativeTo(src))
+    def pipelineCalls[T: upickle.default.Reader](RpcFor: os.SubPath => Option[Rpc]) = {
+      val buffer = collection.mutable.Buffer.empty[(os.RelPath, () => T)]
+      for(p <- subPaths; rpc <- RpcFor(p)) buffer.append((p, callAgent[T](rpc)))
+      buffer.map{case (k, v) => (k, v())}.toMap
+    }
-    for(srcSubPath <- os.walk(src)) { ... }
   }
