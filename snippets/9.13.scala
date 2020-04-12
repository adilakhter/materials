@ import $ivy.`com.atlassian.commonmark:commonmark:0.13.1`

@ val parser = org.commonmark.parser.Parser.builder().build()

@ val document = parser.parse(os.read(os.pwd / "post" / "1 - My First Post.md"))

@ val renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build()

@ val output = renderer.render(document)
output: String = """<p>Sometimes you want numbered lists:</p>
<ol>
<li>One</li>
<li>Two</li>
<li>Three</li>
</ol>
"""
