// MergeSort.sc
     val sortedRight = mergeSort(right)
+    var leftIdx = 0
+    var rightIdx = 0
+    val output = Array.newBuilder[Int]
+    while(leftIdx < sortedLeft.length || rightIdx < sortedRight.length){
+      val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match{
+        case (true, false) => true
+        case (false, true) => false
+        case (true, true) => sortedLeft(leftIdx) < sortedRight(rightIdx)
+      }
+      if (takeLeft){
+        output += sortedLeft(leftIdx)
+        leftIdx += 1
+      }else{
+        output += sortedRight(rightIdx)
+        rightIdx += 1
+      }
+    }
+    output.result()
   }
