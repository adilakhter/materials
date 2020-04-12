@ class Foo(x: Int){
    val bangs = "!" * x
    def printMsg(msg: String) = println(msg + bangs)
  }

@ val f = new Foo(3)

@ f.printMsg("hello")
hello!!!

@ f.printMsg("world")
world!!!
