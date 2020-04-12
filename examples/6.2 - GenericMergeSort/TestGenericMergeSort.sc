import $file.GenericMergeSort, GenericMergeSort._

val input = Vector("banana", "mandarin", "avocado", "apple", "mango", "cherry", "mangosteen")
pprint.log(input)
assert(
  pprint.log(mergeSort(input)) ==
    Vector("apple", "avocado", "banana", "cherry", "mandarin", "mango", "mangosteen")
)