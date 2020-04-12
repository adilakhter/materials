@ {
  def expr[_: P] = P( "(" ~ parser ~ ")" | number )
  def parser[_: P]: P[Int] = P( expr ~ ws ~ operator ~ ws ~ expr )
  }
cmd80.sc:2: type mismatch;
 found   : fastparse.core.Parser[(Int, String, Int)]
 required: fastparse.all.Parser[Int]
    (which expands to)  fastparse.core.Parser[Int]
val parser: Parser[Int] = P( expr ~ ws ~ operator ~ ws ~ expr )
                                                       ^
Compilation Failed
