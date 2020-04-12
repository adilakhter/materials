@ val f = Future{ hash("Chinatown.jpg") }
f: Future[String] = Future(<not completed>)

@ val result = hash("ZCenter.jpg")
result: String = "$2a$17$Ug/BXU3yXVGsQj/FGA.eG.yGE9W7lN3LTKfb1qZss.QTgWb13d7o."

@ val backgroundResult = Await.result(f, Inf)
backgroundResult: String = "$2a$17$O0fnZkDyZ1bsJinOPw.eG.H80jYKe4v1rAF8k5sH9uRue4tma50rK"
