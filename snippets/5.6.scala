@ case class Point(x: Int, y: Int){
    def z = x + y
  }

@ val p = Point(1, 2)

@ p.z
res156: Int = 3
