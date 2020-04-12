@ time{
    val f1 = Future{ hash("Chinatown.jpg") }
    val f2 = Future{ hash("ZCenter.jpg") }
    val res1 = Await.result(f1, Inf)
    val res2 = Await.result(f2, Inf)
    println(res1)
    println(res2)
  }
$2a$17$O0fnZkDyZ1bsJinOPw.eG.H80jYKe4v1rAF8k5sH9uRue4tma50rK
$2a$17$Ug/BXU3yXVGsQj/FGA.eG.yGE9W7lN3LTKfb1qZss.QTgWb13d7o.
res23: (Unit, FiniteDuration) = ((), 9647457101 nanoseconds)
