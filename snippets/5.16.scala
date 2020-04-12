@ def greet(husband: Person, wife: Person) = (husband, wife) match{
    case (Person(s"$first1 $last1", _), Person(s"$first2 $last2", _)) if last1 == last2 =>
      println(s"Hello Mr and Ms $last1")

    case (Person(name1, _), Person(name2, _)) => println(s"Hello $name1 and $name2")
  }

@ greet(Person("Barack Obama", "Pres"), Person("Michelle Obama", "Ms"))
Hello Mr and Ms Obama

@ greet(Person("Barack Obama", "Pres"), Person("Michelle", "Ms"))
Hello Barack Obama and Michelle
