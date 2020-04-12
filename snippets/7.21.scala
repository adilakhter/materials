@ os.write(os.pwd / "new.txt", "Hello World")

@ os.list(os.pwd)
res11: IndexedSeq[os.Path] = ArraySeq(
  /Users/lihaoyi/test/.gitignore,
  /Users/lihaoyi/test/post,
  /Users/lihaoyi/test/new.txt,
)

@ os.read(os.pwd / "new.txt")
res12: String = "Hello World"
