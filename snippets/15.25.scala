@ ctx.run(query[Country].map(c => (c.name, c.continent)))
cmd26.sc:1: SELECT c.name, c.continent FROM country c
res26: List[(String, String)] = List(
  ("Afghanistan", "Asia"),
  ("Netherlands", "Europe"),
  ("Netherlands Antilles", "North America"),
...

@ ctx.run(query[Country].map(c => (c.name, c.continent, c.population)))
cmd27.sc:1: SELECT c.name, c.continent, c.population FROM country c
res27: List[(String, String, Int)] = List(
  ("Afghanistan", "Asia", 22720000),
  ("Netherlands", "Europe", 15864000),
  ("Netherlands Antilles", "North America", 217000),
...
