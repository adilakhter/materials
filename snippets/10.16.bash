$ ./mill resolve __.concat
foo[bar].concat
foo[qux].concat

$ mkdir -p foo/thing/src

$ ./mill resolve __.concat
foo[bar].concat
foo[qux].concat
foo[thing].concat
