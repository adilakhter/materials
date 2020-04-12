@ for(i <- Range.inclusive(1, 100)){
    println(
      (i % 3 == 0, i % 5 == 0) match{
        case (true, true) => "FizzBuzz"
        case (true, false) => "Fizz"
        case (false, true) => "Buzz"
        case (false, false) => i
      }
    )
  }
1
2
Fizz
4
Buzz
...
