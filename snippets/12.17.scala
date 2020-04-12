@ for((number, title, body, user) <- issueData.sortBy(_._1)){
    println(s"Creating issue $number")
    val resp = requests.post(
      "https://api.github.com/repos/lihaoyi/test/issues",
      data = ujson.Obj(
        "title" -> title,
        "body" -> s"$body\nID: $number\nOriginal Author: $user"
      ),
      headers = Map("Authorization" -> s"token $token")
    )
  }
Creating issue 1
Creating issue 2
...
Creating issue 272
