@ fastparse.parse("hello (goodbye seattle)", parser(_))
res67: Parsed[Phrase] = Success(
  Pair(
    Word("hello"),
    Pair(Word("goodbye"), Word("seattle"))
  ),
  23
)

@ fastparse.parse("(hello  world)   ((goodbye seattle) world)", parser(_))
res69: Parsed[Phrase] = Success(
  Pair(
    Pair(Word("hello"), Word("world")),
    Pair(
      Pair(Word("goodbye"), Word("seattle")),
      Word("world")
    )
  ),
  42
)
