@ val t = new Trie()

@ t.add("mango"); t.add("mandarin"); t.add("map"); t.add("man")

@ t.contains("mango")
res86: Boolean = true

@ t.contains("mang")
res87: Boolean = false

@ t.contains("man")
res88: Boolean = true

@ t.contains("mandarin")
res89: Boolean = true

@ t.contains("mandarine")
res90: Boolean = false
