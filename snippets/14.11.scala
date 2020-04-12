// app/src/MinimalApplication.scala
 object MinimalApplication extends cask.MainRoutes{
+ var messages = Vector(("alice", "Hello World!"), ("bob", "I am cow, hear me moo"))
  @cask.get("/")
