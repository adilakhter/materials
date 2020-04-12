@ def stringify(e: Expr): String = e match{
    case BinOp(left, op, right) => s"(${stringify(left)} $op ${stringify(right)})"
    case Number(0) => "zero"; case Number(1) => "one"
    case Number(2) => "two"; case Number(3) => "three"
    case Number(4) => "four"; case Number(5) => "five"
    case Number(6) => "six"; case Number(7) => "seven"
    case Number(8) => "eight"; case Number(9) => "seven"
  }

@ stringify(t)
res5: String = "((one plus two) times (three plus four))"
