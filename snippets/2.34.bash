$ ./mill foo.test
[info] Compiling 1 Scala source ...
[info] Done compiling.
-------------------------------- Running Tests --------------------------------
+ foo.ExampleTests.hello 8ms  Hello World
X foo.ExampleTests.iAmCow 2ms
  utest.AssertionError: assert(result == "I am Cow")
  result: String = Hear me Moo
    utest.asserts.Asserts$.assertImpl(Asserts.scala:116)
    foo.ExampleTests$.$anonfun$tests$4(ExampleTests.scala:12)
1 targets failed
foo.test.test foo.ExampleTests foo.ExampleTests.iAmCow
