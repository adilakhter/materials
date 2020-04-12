     sealed trait Msg
     case class ChangedPath(value: os.SubPath) extends Msg
-    case class AgentResponse(value: Rpc.StatInfo) extends Msg
+    case class HashStatInfo(localHash: Option[Int], value: Rpc.StatInfo) extends Msg

     object SyncActor extends castor.SimpleActor[Msg]{
       def run(msg: Msg): Unit = {
         println("SyncActor handling: " + msg)
         msg match{
           case ChangedPath(value) => Shared.send(agent.stdin.data, Rpc.StatPath(value))
-          case AgentResponse(Rpc.StatInfo(p, remoteHash)) =>
-            val localHash = Shared.hashPath(src / p)
+          case HashStatInfo(localHash, Rpc.StatInfo(p, remoteHash)) =>
             if (localHash != remoteHash && localHash.isDefined){
               Shared.send(agent.stdin.data, Rpc.WriteOver(os.read.bytes(src / p), p))
             }
         }
       }
     }
+    object HashActor extends castor.SimpleActor[Rpc.StatInfo]{
+      def run(msg: Rpc.StatInfo): Unit = {
+        println("HashActor handling: " + msg)
+        val localHash = Shared.hashPath(src / msg.p)
+        SyncActor.send(HashStatInfo(localHash, msg))
+      }
+    }

     val agentReader = new Thread(() => {
       while(agent.isAlive()){
-        SyncActor.send(AgentResponse(Shared.receive[Rpc.StatInfo](agent.stdout.data)))
+        HashActor.send(Shared.receive[Rpc.StatInfo](agent.stdout.data))
       }
     })
