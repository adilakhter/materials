@ for(headline <- headlines) yield (headline.attr("title"), headline.attr("href"))
res15: collection.mutable.Buffer[(String, String)] = ArrayBuffer(
  ("Bek Air Flight 2100", "/wiki/Bek_Air_Flight_2100"),
  ("Assassination of ...", "/wiki/Assassination_of_..."),
  ("State of the...", "/wiki/State_of_the_..."),
...

@ for(headline <- headlines) yield headline.text
res10: collection.mutable.Buffer[String] = ArrayBuffer(
  "Bek Air Flight 2100",
  "2018 killing",
  "upholds a ruling",
...
