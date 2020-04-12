implicit val cc = new castor.Context.Test(
  scala.concurrent.ExecutionContext.fromExecutor(
    java.util.concurrent.Executors.newSingleThreadExecutor()
  )
){
  override def reportRun(a: castor.Actor[_],
                         msg: Any,
                         token: castor.Context.Token): Unit = {
    println(s"$a <- $msg")
    super.reportRun(a, msg, token)
  }
}
