// SimpleUploadActor.sc
import $ivy.`com.lihaoyi::castor:0.1.3`
class SimpleUploadActor()(implicit cc: castor.Context) extends castor.SimpleActor[String]{
  def run(msg: String) = {
    println(s"Uploading $msg")
    val res = requests.post("https://httpbin.org/post", data = msg)
    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}

import castor.Context.Simple.global
val uploader = new SimpleUploadActor()
