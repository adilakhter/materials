val diskActor1 = new DiskActor(os.home / "log.txt")
val diskActor2 = new DiskActor(os.pwd / "log.txt")
val diskActor3 = new DiskActor(os.root / "tmp" / "log.txt")

val base64Actor = new Base64Actor(diskActor1)
val sanitizeActor = new SanitizeActor(
  new castor.SplitActor(base64Actor, diskActor2, diskActor3)
)

val logger = sanitizeActor
