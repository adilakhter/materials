// Trie.scala
+ def prefixesMatchingString(s: String): Seq[String] = {
+   prefixesMatchingString0(s).map(s.substring(0, _))
+ }
