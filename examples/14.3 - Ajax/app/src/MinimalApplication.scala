package app
import scalatags.Text.all._
object MinimalApplication extends cask.MainRoutes{
  var messages = Vector(("alice", "Hello World!"), ("bob", "I am cow, hear me moo"))

  @cask.get("/")
  def hello() = doctype("html")(
    html(
      head(
        link(
          rel := "stylesheet",
          href := "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css"
        ),
        script(raw("""
          function submitForm(){
            fetch(
              "/",
              {
                method: "POST",
                body: JSON.stringify({name: nameInput.value, msg: msgInput.value})
              }
            ).then(response => response.json())
             .then(json => {
              if (json["success"]) {
                messageList.innerHTML = json["txt"]
                msgInput.value = ""
              }
              errorDiv.innerText = json["err"]
            })
          }
        """))
      ),
      body(
        div(cls := "container")(
          h1("Scala Chat!"),
          div(id := "messageList")(messageList()),
          div(id := "errorDiv", color.red),
          form(onsubmit := "submitForm(); return false")(
            input(`type` := "text", id := "nameInput", placeholder := "User name"),
            input(`type` := "text", id := "msgInput", placeholder := "Write a message!"),
            input(`type` := "submit")
          )
        )
      )
    )
  )

  def messageList() = frag(for((name, msg) <- messages) yield p(b(name), " ", msg))

  @cask.postJson("/")
  def postHello(name: String, msg: String) = {
    if (name == "") ujson.Obj("success" -> false, "err" -> "Name cannot be empty")
    else if (msg == "") ujson.Obj("success" -> false, "err" -> "Message cannot be empty")
    else {
      messages = messages :+ (name -> msg)
      ujson.Obj("success" -> true, "txt" -> messageList().render, "err" -> "")
    }
  }

  initialize()
}
