// build.sc
- val bootstrapCss = link(
-   rel := "stylesheet",
-   href := "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css"
- )
+ def bootstrap = T{
+   os.write(
+     T.dest / "bootstrap.css",
+     requests.get("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css")
+       .text()
+   )
+   PathRef(T.dest / "bootstrap.css")
+ }
