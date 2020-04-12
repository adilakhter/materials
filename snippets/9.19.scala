// Blog.sc
       html(
         body(
-          h1("Blog", " / ", suffix.stripSuffix(".md")),
+          h1(a(href := "../index.html")("Blog"), " / ", suffix.stripSuffix(".md")),
           raw(output)
         )
       )
