// Blog.sc
   os.write(
     os.pwd / "out" / "post" / mdNameToHtml(suffix),
     doctype("html")(
       html(
+        head(bootstrapCss),
         body(
           h1(a("Blog", href := "../index.html"), " / ", suffix.stripSuffix(".md")),
