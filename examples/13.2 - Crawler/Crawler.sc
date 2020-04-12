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

def fetchAllLinksParallel(startTitle: String, depth: Int) = {
  var seen = Set(startTitle)
  var currentTitles = Set(startTitle)
  for(i <- 0 until depth){
    val futures = for(title <- currentTitles) yield Future{ fetchLinks(title) }
    val nextTitleLists = futures.map(Await.result(_, Inf))
    currentTitles = nextTitleLists.flatten.filter(!seen.contains(_))
    seen = seen ++ currentTitles
  }
  seen
}
// Usage
assert(
  pprint.log(fetchAllLinksParallel("Singapore", 0)) ==
  Set("Singapore")
)
assert(
  pprint.log(fetchAllLinksParallel("Singapore", 1)) ==
  Set(
    "1954 National Service riots",
    "16th Summit of the Non-Aligned Movement",
    "126 Squadron, Republic of Singapore Air Force",
    "+65",
    "1915 Singapore Mutiny",
    "1962 Merger Referendum of Singapore",
    "13th Parliament of Singapore",
    "Singapore",
    "1964 race riots in Singapore",
    "1959 Singaporean general election",
    ".sg"
  )
)

pprint.log(fetchAllLinksParallel("Singapore", 2))
pprint.log(fetchAllLinksParallel("Singapore", 3))