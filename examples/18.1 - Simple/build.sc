// build.sc
import mill._, scalalib._

trait SyncModule extends ScalaModule{
  def scalaVersion = "2.13.1"
  def ivyDeps = Agg(
    ivy"com.lihaoyi::upickle:0.9.7",
    ivy"com.lihaoyi::os-lib:0.6.3",
    ivy"com.lihaoyi::os-lib-watch:0.6.3",
    ivy"com.lihaoyi::castor:0.1.3"
  )
}
object sync extends SyncModule{
  def moduleDeps = Seq(shared)
  def resources = T.sources{
    os.copy(agent.assembly().path, T.dest / "agent.jar")
    Seq(PathRef(T.dest))
  }
}
object agent extends SyncModule{
  def moduleDeps = Seq(shared)
}
object shared extends SyncModule