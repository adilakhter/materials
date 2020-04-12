@ {
  def expr[_: P] = P( "(" ~ parser ~ ")" | number )
  def parser[_: P]: P[Int] = P( expr ~ ws ~ operator ~ ws ~ expr ).map{
    case (lhs, "plus", rhs) => lhs + rhs
    case (lhs, "minus", rhs) => lhs - rhs
    case (lhs, "times", rhs) => lhs * rhs
    case (lhs, "divide", rhs) => lhs / rhs
  }
  }
