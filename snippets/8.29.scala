@ val str = upickle.default.write(os.pwd)
str: String = "\"/Users/lihaoyi/Github/hands-on-scala-book\""

@ upickle.default.read[os.Path](str)
res3: os.Path = /Users/lihaoyi/Github/hands-on-scala-book
