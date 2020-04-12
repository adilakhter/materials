// MergeSort.sc
def mergeSort(items: Array[Int]): Array[Int] = {
  if (items.length == 1) items
  else {
    val (left, right) = items.splitAt(items.length / 2)
    val sortedLeft = mergeSort(left)
    val sortedRight = mergeSort(right)
  }
}
