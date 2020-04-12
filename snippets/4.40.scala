@ val myArrayDeque = collection.mutable.ArrayDeque(1, 2, 3, 4, 5)
myArrayDeque: collection.mutable.ArrayDeque[Int] = ArrayDeque(1, 2, 3, 4, 5)

@ myArrayDeque.removeHead()
res1: Int = 1

@ myArrayDeque.append(6)
res2: collection.mutable.ArrayDeque[Int] = ArrayDeque(2, 3, 4, 5, 6)

@ myArrayDeque.removeHead()
res3: Int = 2

@ myArrayDeque
res4: collection.mutable.ArrayDeque[Int] = ArrayDeque(3, 4, 5, 6)
