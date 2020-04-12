@ println(
    serialize(
      evaluate(
        fastparse.parse(
          """local x = "Hello "; local y = "world"; x + y""",
          Parser.expr(_)
        ).get.value,
        Map.empty
      )
    )
  )
"Hello world"
