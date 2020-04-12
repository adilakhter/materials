@ val author = upickle.default.read[Author](data(0)("author")) // read from JSON structure
author: Author = Author("Ammonite-Bot", 20607116, false)

@ author.login
res60: String = "Ammonite-Bot"

@ author.id
res61: Int = 20607116

@ author.site_admin
res62: Boolean = false

@ val author2 = upickle.default.read[Author](  // read directly from a String
    """{"login": "lihaoyi", "id": 313373, "site_admin": true}"""
  )
author2: Author = Author("lihaoyi", 313373, true)

@ upickle.default.write(author2)
res10: String = "{\"login\":\"lihaoyi\",\"id\":313373,\"site_admin\":true}"
