@ val t = new Trie(); t.add("mango"); t.add("mandarin"); t.add("map"); t.add("man")

@ t.stringsMatchingPrefix("man")
res121: Seq[String] = List("man", "mandarin", "mango")

@ t.stringsMatchingPrefix("ma")
res122: Seq[String] = List("map", "man", "mandarin", "mango")

@ t.stringsMatchingPrefix("map")
res123: Seq[String] = List("map")

@ t.stringsMatchingPrefix("mand")
res124: Seq[String] = List("mandarin")

@ t.stringsMatchingPrefix("mando")
res125: Seq[String] = List()
