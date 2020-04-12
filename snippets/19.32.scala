def expr[_: P]: P[Int] = P( "(" ~ parser ~ ")" | number )
def parser[_: P]: P[Int] = P( expr ~ ws ~ operator ~ ws ~ expr )
