@ def evaluate(e: Expr): Int = e match{
    case BinOp(left, "plus", right) => evaluate(left) + evaluate(right)
    case BinOp(left, "minus", right) => evaluate(left) + evaluate(right)
    case BinOp(left, "times", right) => evaluate(left) + evaluate(right)
    case BinOp(left, "divide", right) => evaluate(left) + evaluate(right)
    case Number(n) => n
  }

@ evaluate(t)
res7: Int = 10
