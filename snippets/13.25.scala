// Crawler.sc
import scala.concurrent._, ExecutionContext.Implicits.global, duration.Duration._

def fetchLinks(title: String): Seq[String] = {
  val resp = requests.get(
    "https://en.wikipedia.org/w/api.php",
    params = Seq(
      "action" -> "query",
      "titles" -> title,
      "prop" -> "links",
      "format" -> "json"
    )
  )
  ujson
    .read(resp.text())("query")("pages")
    .obj
    .values
    .filter(_.obj.contains("links"))
    .flatMap(_("links").arr).map(_("title").str)
    .toSeq
}

def fetchAllLinksParallel(startTitle: String, depth: Int): Set[String] = {
  var seen = Set(startTitle)
  var current = Set(startTitle)
  for(i <- Range(0, depth)){
    val futures = for(title <- current) yield Future{ fetchLinks(title) }
    val nextTitleLists = futures.map(Await.result(_, Inf))
    current = nextTitleLists.flatten.filter(!seen.contains(_))
    seen = seen ++ nextTitleLists.flatten
  }
  seen
}

val fetched = fetchAllLinksParallel("Singapore", 3)
