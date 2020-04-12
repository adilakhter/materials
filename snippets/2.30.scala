// foo/test/src/ExampleTests.scala
       result
     }
+    test("iAmCow"){
+      val result = Example.iAmCow()
+      assert(result == "I am Cow")
+      result
+    }
   }
 }
