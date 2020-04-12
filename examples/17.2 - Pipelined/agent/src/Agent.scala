// agent/src/Agent.scala
package sync
object Agent {
  def main(args: Array[String]): Unit = {
    val bytesIn = new java.io.DataInputStream(System.in)
    val bytesOut = new java.io.DataOutputStream(System.out)
    while(true) try{
      val rpc = Shared.receive[Rpc](bytesIn)
      rpc match{
        case Rpc.IsDir(path) => Shared.send(bytesOut, os.isDir(os.pwd / path))
        case Rpc.Exists(path) => Shared.send(bytesOut, os.exists(os.pwd / path))
        case Rpc.ReadBytes(path) => Shared.send(bytesOut, os.read.bytes(os.pwd / path))
        case Rpc.WriteOver(bytes, path) =>
          os.remove.all(os.pwd / path)
          Shared.send(bytesOut, os.write.over(os.pwd / path, bytes, createFolders = true))
      }
    }catch{case e: java.io.EOFException => System.exit(0)}
  }
}