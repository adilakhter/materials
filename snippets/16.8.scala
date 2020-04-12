// SimpleUploadActor.sc
+ var count = 0
  def run(msg: String) = {
    println(s"Uploading $msg")
    val res = requests.post("https://httpbin.org/post", data = msg)
+   count += 1
-   println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
+   println(s"response #$count ${res.statusCode} " + ujson.read(res.text())("data"))
  }
