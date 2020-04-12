@ os.read.lines(os.pwd / ".gitignore")
res8: IndexedSeq[String] = ArraySeq(
  "target/",
  "*.iml",
  ".idea",
...

@ os.read.bytes(os.pwd / ".gitignore")
res9: Array[Byte] = Array(
  116,
  97,
  114,
...
