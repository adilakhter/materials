@ evaluate(
    fastparse.parse(
      """local greeting = "Hello ";
         local person = function (name) {
           "name": name,
           "welcome": greeting + name + "!"
         };
         {
           "person1": person("Alice"),
           "person2": person("Bob"),
           "person3": person("Charlie")
         }
      """,
      Parser.expr(_)
    ).get.value,
    Map.empty
  )
res132: Value = Dict(
  Map(
    "person1" -> Dict(Map("name" -> Str("Alice"), "welcome" -> Str("Hello Alice!"))),
    "person2" -> Dict(Map("name" -> Str("Bob"), "welcome" -> Str("Hello Bob!"))),
    "person3" -> Dict(Map("name" -> Str("Charlie"), "welcome" -> Str("Hello Charlie!")))
  )
)
