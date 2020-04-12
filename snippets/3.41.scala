@ printHello2("1") // wrong type of argument
cmd128.sc:1: type mismatch;
 found   : String("1")
 required: Int
val res128 = printHello2("1")
                         ^
Compilation Failed

@ printHello() // missing argument
cmd121.sc:1: not enough arguments for method printHello: (times: Int)Unit.
Unspecified value parameter times.
val res121 = printHello()
                       ^
Compilation Failed
