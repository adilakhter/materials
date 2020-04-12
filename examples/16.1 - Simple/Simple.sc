// Simple.sc
import $ivy.`com.lihaoyi::castor:0.1.3`

class SimpleUploadActor()(implicit cc: castor.Context)
extends castor.SimpleActor[String]{
  var count = 0
  def run(msg: String) = {
    println(s"Uploading $msg")
    val res = requests.post("https://httpbin.org/post", data=msg)
    count += 1
    println(s"response $count ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}

implicit val cc = new castor.Context.Test()
val uploader = new SimpleUploadActor()

// Usage
println("sending hello")
uploader.send("hello")

println("sending world")
uploader.send("world")

println("sending !")
uploader.send("!")

cc.waitForInactivity()

// Validation

synchronized(assert(uploader.count == 3))