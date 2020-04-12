@ class Bar(val x: Int){
    def printMsg(msg: String) = println(msg + x)
  }

@ val b = new Bar(1)

@ b.x
res134: Int = 1
