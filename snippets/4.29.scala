@ def lengthOfName(nameOpt: Option[String]) = nameOpt.map(_.length).getOrElse(-1)

@ lengthOfName(Some("Haoyi"))
res6: Int = 5

@ lengthOfName(None)
res7: Int = -1
