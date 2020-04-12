// app/src/MinimalApplication.scala
-   def hello() = {
-     "Hello World!"
-   }
+   def hello() = doctype("html")(
+     html(
+       head(
+         link(
+           rel := "stylesheet",
+           href := "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css"
+         )
+       ),
+       body(
+         div(cls := "container")(
+           h1("Hello!"),
+           p("World")
+         )
+       )
+     )
+   )
