@ def parser[_: P]: P[Phrase] =
    P( ("hello" | "goodbye").! ~ " ".rep(1) ~ ("world" | "seattle").! ~ End ).map{
      case ("hello", place) => new Phrase(true, place)
      case ("goodbye", place) => new Phrase(false, place)
    }

@ fastparse.parse("hello world", parser(_))
res45: Parsed[Phrase] = Success(Phrase(true, "world"), 11)

@ fastparse.parse("goodbye   seattle", parser(_))
res46: Parsed[Phrase] = Success(Phrase(false, "seattle"), 17)
