@ val str2 = upickle.default.write(Array(os.pwd, os.home, os.root))
str2: String = "[\"/Users/lihaoyi/Github/hands-on-scala-book\",\"/Users/lihaoyi\",\"/\"]"

@ upickle.default.read[Array[os.Path]](str2)
res6: Array[os.Path] = Array(/Users/lihaoyi/Github/hands-on-scala-book, /Users/lihaoyi, /)
