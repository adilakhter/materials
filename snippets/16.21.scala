val diskActor = new DiskActor(os.pwd / "log.txt")
val uploadActor = new UploadActor("https://httpbin.org/post")

val base64Actor = new Base64Actor(diskActor)
val sanitizeActor = new SanitizeActor(uploadActor)

val logger = new castor.SplitActor(base64Actor, sanitizeActor)
