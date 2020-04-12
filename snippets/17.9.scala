// agent/src/Agent.scala
package sync
object Agent {
  def main(args: Array[String]): Unit = {
    val bytesIn = new java.io.DataInputStream(System.in)
    val bytesOut = new java.io.DataOutputStream(System.out)
    while(true) try{
      val rpc = Shared.receive[Rpc](bytesIn)
    }catch{case e: java.io.EOFException => System.exit(0)}
  }
}
