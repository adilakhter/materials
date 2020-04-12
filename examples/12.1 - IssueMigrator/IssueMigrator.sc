
if(sys.env.contains("COMPILE_ONLY")) System.exit(0)

val srcRepo = scala.io.StdIn.readLine("Source repo, e.g. lihaoyi/upickle: ")
val destRepo = scala.io.StdIn.readLine("Destination repo, e.g. lihaoyi/test: ")
val token = scala.io.StdIn.readLine("Github Token: ")

pprint.log(srcRepo)
pprint.log(destRepo)
pprint.log(token)

def fetchPaginated(url: String, params: (String, String)*) = {
  var done = false
  var page = 1
  val responses = collection.mutable.Buffer.empty[ujson.Value]
  while(!done){
    println("page " + page + "...")
    val resp = requests.get(
      url,
      params = Map("page" -> page.toString) ++ params,
      headers = Map("Authorization" -> s"token $token")
    )
    val parsed = ujson.read(resp.text()).arr
    if (parsed.length == 0) done = true
    else responses.appendAll(parsed)
    page += 1
  }
  responses
}

val issues =
  fetchPaginated(s"https://api.github.com/repos/$srcRepo/issues", "state" -> "all")

val nonPullRequests = issues.filter(!_.obj.contains("pull_request"))

val issueData = for(issue <- nonPullRequests) yield (
  issue("number").num.toInt,
  issue("title").str,
  issue("body").str,
  issue("user")("login").str
)

val comments =
  fetchPaginated(s"https://api.github.com/repos/$srcRepo/issues/comments")

val commentData = for(comment <- comments) yield (
  comment("issue_url").str match{
    case s"https://api.github.com/repos/lihaoyi/$repo/issues/$id" => id.toInt
  },
  comment("user")("login").str,
  comment("body").str
)


for((number, title, body, user) <- issueData.sortBy(_._1)){
  println(s"Creating issue $number")
  val resp = requests.post(
    s"https://api.github.com/repos/$destRepo/issues",
    data = ujson.Obj(
      "title" -> title,
      "body" -> s"$body\nID: $number\nOriginal Author: $user"
    ),
    headers = Map("Authorization" -> s"token $token")
  )
  println(resp.statusCode)
}

val issueNumMap = issueData
  .sortBy(_._1)
  .map(_._1)
  .zipWithIndex
  .toMap
  .map{case (k, v) => (k, v + 1 + 1)}

for((issueId, user, body) <- commentData; newIssueId <- issueNumMap.get(issueId)){
  println(s"Commenting on issue old_id=$issueId new_id=$newIssueId")
  val resp = requests.post(
    s"https://api.github.com/repos/lihaoyi/test/issues/$newIssueId/comments",
    data = ujson.Obj("body" -> s"$body\nOriginal Author:$user"),
    headers = Map("Authorization" -> s"token $token")
  )
  println(resp.statusCode)
}