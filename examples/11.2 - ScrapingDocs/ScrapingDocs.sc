// ScrapingDocs.sc
import $ivy.`org.jsoup:jsoup:1.12.1`, org.jsoup._
import collection.JavaConverters._
val indexDoc = Jsoup.connect("https://developer.mozilla.org/en-US/docs/Web/API").get()
val links = indexDoc.select("h2#Interfaces").nextAll.select("div.index a")
val linkData = links.asScala.map(link => (link.attr("href"), link.attr("title"), link.text))

// Only scrape documentation for APIs whose name starts with "A", so it finishes faster
val articles = for((url, tooltip, name) <- linkData if name.startsWith("A")) yield {
  println("Scraping " + name)
  val doc = Jsoup.connect("https://developer.mozilla.org" + url).get()
  val summary = doc.select("article#wikiArticle > p").asScala.headOption match{
    case Some(n) => n.text
    case None => ""
  }
  val methodsAndProperties = doc
    .select("article#wikiArticle dl dt")
    .asScala
    .map(elem => (elem.text, elem.nextElementSibling match {case null => "" case x => x.text}))
  (url, tooltip, name, summary, methodsAndProperties)
}

pprint.log(articles)
assert(articles.exists(_._3 == "AnalyserNode"))
assert(articles.exists(_._3 == "AbortController"))
assert(articles.exists(_._3 == "AmbientLightSensor"))
assert(pprint.log(articles.length) == 46)