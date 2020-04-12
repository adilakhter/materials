@ class Foo(x: Int){
    def printMsg(msg: String) = println(msg + x)
  }

@ val f = new Foo(1)

@ f.printMsg("hello")
hello1

@ f.printMsg("world")
world1
