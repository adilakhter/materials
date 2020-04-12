@ val v = Vector(1, 2, 3, 4, 5)
v: Vector[Int] = Vector(1, 2, 3, 4, 5)

@ v(0)
res174: Int = 1

@ val v2 = v.updated(2, 10)
v2: Vector[Int] = Vector(1, 2, 10, 4, 5)

@ v2
res176: Vector[Int] = Vector(1, 2, 10, 4, 5)

@ v // note that `v` did not change when we created `v2` with an updated element!
res177: Vector[Int] = Vector(1, 2, 3, 4, 5)
