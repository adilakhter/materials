// LoggingPipeline.sc
 class DiskActor...
 class Base64Actor...
+class UploadActor(url: String)
+                 (implicit cc: castor.Context) extends castor.SimpleActor[String]{
+  def run(msg: String) = {
+    val res = requests.post(url, data = msg)
+    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
+  }
+}
+class SanitizeActor(dest: castor.Actor[String])
+                   (implicit cc: castor.Context) extends castor.SimpleActor[String]{
+  def run(msg: String) = {
+    dest.send(msg.replaceAll("([0-9]{4})[0-9]{8}([0-9]{4})", "<redacted>"))
+  }
+}

 implicit val cc = new castor.Context.Test()

 val diskActor = new DiskActor(os.pwd / "log.txt")
+val uploadActor = new UploadActor("https://httpbin.org/post")
-val base64Actor = new Base64Actor(diskActor)
+val base64Actor = new Base64Actor(new castor.SplitActor(diskActor, uploadActor))
+val sanitizeActor = new SanitizeActor(base64Actor)
-val logger = base64Actor
+val logger = sanitizeActor
