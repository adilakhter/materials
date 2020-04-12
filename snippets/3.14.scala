@ val s = "hello" + 1 + " " + "world" + 2
s: String = "hello1 world2"

@ val x = 1; val y = 2

@ val s = s"Hello $x World $y"
s: String = "Hello 1 World 2"

@ val s = s"Hello ${x + y} World ${x - y}"
s: String = "Hello 3 World -1"
