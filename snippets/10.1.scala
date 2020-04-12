def sources = T.source(os.pwd / "src")

def concat = T{
  os.write(T.dest / "concat.txt",  os.list(srcs().path).map(os.read(_)))
  PathRef(T.dest / "concat.txt")
}
