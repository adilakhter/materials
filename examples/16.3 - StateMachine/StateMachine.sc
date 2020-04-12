// StateMachine.sc
import $ivy.`com.lihaoyi::castor:0.1.3`

sealed trait Msg
case class Text(s: String) extends Msg
case class Flush() extends Msg
class StateMachineUploadActor()(implicit cc: castor.Context)
extends castor.StateMachineActor[Msg]{
  @volatile var responseCount = 0
  def initialState = new Idle()

  case class Idle() extends State({
    case Text(msg) => upload(msg)
  })

  case class Buffering(msgs: Vector[String]) extends State({
    case Text(s) => Buffering(msgs :+ s)
    case Flush() =>
      if (msgs.isEmpty) Idle()
      else upload(msgs.mkString)
  })

  def upload(data: String) = {
    println("Uploading " + data)
    val res = requests.post("https://httpbin.org/post", data=data)
    responseCount += 1
    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
    cc.scheduleMsg(this, Flush(), java.time.Duration.ofSeconds(5))
    Buffering(Vector.empty)
  }
}


implicit val cc = new castor.Context.Test()

val stateMachineUploader = new StateMachineUploadActor()

// Usage
println("Sending...")
stateMachineUploader.send(Text("I am Cow"))
Thread.sleep(5000)

println("Sending...")
stateMachineUploader.send(Text("Hear me moo"))
println("Sending...")
stateMachineUploader.send(Text("I weigh twice as much as you"))
Thread.sleep(5000)

println("Sending...")
stateMachineUploader.send(Text("And I look good on the barbecue"))
cc.waitForInactivity()

// Validation
assert(stateMachineUploader.responseCount == 3)