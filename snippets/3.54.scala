@ class Qux(var x: Int){
    def printMsg(msg: String) = {
      x += 1
      println(msg + x)
    }
  }

@ val q = new Qux(1)

@ q.printMsg("hello")
hello2

@ q.printMsg("hello")
hello3
