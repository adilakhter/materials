// build.sc
import mill._, scalalib._

trait SyncModule extends ScalaModule{
  def scalaVersion = "2.13.1"
  def ivyDeps = Agg(
    ivy"com.lihaoyi::upickle:1.0.0",
    ivy"com.lihaoyi::os-lib:0.6.3"
  )
}

object shared extends SyncModule

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
