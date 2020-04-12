@ Set(1, 2, 3) + 4 + 5
res216: Set[Int] = HashSet(5, 1, 2, 3, 4)

@ Set(1, 2, 3) - 2
res217: Set[Int] = Set(1, 3)

@ Set(1, 2, 3) ++ Set(2, 3, 4) // Note that duplicates are discarded
res218: Set[Int] = Set(1, 2, 3, 4)
