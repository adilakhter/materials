@ def getIndexTwoAndFour[T](items: IndexedSeq[T]) = (items(2), items(4))

@ getIndexTwoAndFour(Vector(1, 2, 3, 4, 5))
res288: (Int, Int) = (3, 5)

@ getIndexTwoAndFour(Array(2, 4, 6, 8, 10))
res289: (Int, Int) = (6, 10)
