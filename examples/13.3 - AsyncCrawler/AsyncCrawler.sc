// Crawler.sc
import $ivy.`org.asynchttpclient:async-http-client:2.5.2`

import scala.concurrent._, ExecutionContext.Implicits.global, duration.Duration._

val asyncHttpClient = org.asynchttpclient.Dsl.asyncHttpClient()

def fetchLinksAsync(title: String): Future[Seq[String]] = {
  val p = Promise[String]
  val listenableFut = asyncHttpClient.prepareGet("https://en.wikipedia.org/w/api.php")
    .addQueryParam("action", "query").addQueryParam("titles", title)
    .addQueryParam("prop", "links").addQueryParam("format", "json")
    .execute()

  listenableFut.addListener(() => p.success(listenableFut.get().getResponseBody), null)
  val scalaFut: Future[String] = p.future
  scalaFut.map{ responseBody =>
    for{
      page <- ujson.read(responseBody)("query")("pages").obj.values.toSeq
      links <- page.obj.get("links").toSeq
      link <- links.arr
    } yield link("title").str
  }
}

def fetchAllLinksAsync(startTitle: String, depth: Int): Future[Set[String]] = {
  def rec(current: Set[String], seen: Set[String], recDepth: Int): Future[Set[String]] = {
    if (recDepth >= depth) Future.successful(seen)
    else {
      val futures = for(title <- current) yield fetchLinksAsync(title)
      Future.sequence(futures).map{nextTitleLists =>
        rec(
          nextTitleLists.flatten.filter(!seen.contains(_)),
          seen ++ nextTitleLists.flatten,
          recDepth + 1
        )
      }.flatten
    }
  }
  rec(Set(startTitle), Set(startTitle), 0)
}
// Usage
assert(
  pprint.log(Await.result(fetchAllLinksAsync("Singapore", 0), Inf)) ==
  Set("Singapore")
)
assert(
  pprint.log(Await.result(fetchAllLinksAsync("Singapore", 1), Inf)) ==
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

pprint.log(Await.result(fetchAllLinksAsync("Singapore", 2), Inf))
pprint.log(Await.result(fetchAllLinksAsync("Singapore", 3), Inf))