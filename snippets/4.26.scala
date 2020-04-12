@ def hello(firstName: String, lastNameOpt: Option[String]) = lastNameOpt match{
    case Some(lastName) => println(s"Hello Mr. $lastName")
    case None => println(s"Hello $firstName")
  }

@ hello("Haoyi", None)
Hello Haoyi

@ hello("Haoyi", Some("Li"))
Hello Mr. Li
