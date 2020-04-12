@ def hello2(nameOpt: Option[String]) = {
    for(name <- nameOpt) println(s"Hello $name")
  }

@ hello2(None) // does nothing

@ hello2(Some("Haoyi"))
Hello Haoyi
