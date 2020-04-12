@ Array(1, 2, 3, 4, 5, 6, 7).foldLeft(0)((x, y) => x + y) // sum of all elements
res19: Int = 28

@ Array(1, 2, 3, 4, 5, 6, 7).foldLeft(1)((x, y) => x * y) // product of all elements
res20: Int = 5040

@ Array(1, 2, 3, 4, 5, 6, 7).foldLeft(1)(_ * _) // same as above, shorthand syntax
res21: Int = 5040
