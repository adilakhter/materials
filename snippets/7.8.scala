@ os.Path("post")
java.lang.IllegalArgumentException: requirement failed: post is not an absolute path

@ os.Path("post", base = os.pwd)
res15: os.Path = /Users/lihaoyi/test/post

@ os.Path("../Ammonite", base = os.pwd)
res16: os.Path = /Users/lihaoyi/Ammonite

@ os.Path("/Users/lihaoyi", base = os.pwd) // base is ignored if path is already absolute
res17: os.Path = /Users/lihaoyi
