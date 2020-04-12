import $file.Trie, Trie._

val t = new Trie()

t.add("mango")
t.add("mandarin")
t.add("map")
t.add("man")

assert(pprint.log(t.contains("mango")) == true)

assert(pprint.log(t.contains("mang")) == false)

assert(pprint.log(t.contains("man")) == true)

assert(pprint.log(t.contains("mandarin")) == true)

assert(pprint.log(t.contains("mandarine")) == false)

assert(pprint.log(t.prefixesMatchingString("mangosteen")) == List("man", "mango"))

assert(pprint.log(t.stringsMatchingPrefix("man")) == List("man", "mandarin", "mango"))

assert(pprint.log(t.stringsMatchingPrefix("ma")) == List("map", "man", "mandarin", "mango"))

assert(pprint.log(t.stringsMatchingPrefix("map")) == List("map"))

assert(pprint.log(t.stringsMatchingPrefix("mand")) == List("mandarin"))

assert(pprint.log(t.stringsMatchingPrefix("mando")) == List())