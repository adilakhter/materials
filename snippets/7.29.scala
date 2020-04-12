@ { os.read.lines.stream(os.pwd / ".gitignore")
      .filter(_.startsWith("."))
      .map(_.drop(1))
      .toList }
res23: List[String] = List(
  "idea",
  "settings",
  "classpath",
  ...
