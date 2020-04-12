@ {
  println("sending hello")
  uploader.send("hello")

  println("sending world")
  uploader.send("world")

  println("sending !")
  uploader.send("!")
  }

sending hello
sending world
sending !

Uploading hello
response 200 "hello"
Uploading world
response 200 "world"
Uploading !
response 200 "!"
