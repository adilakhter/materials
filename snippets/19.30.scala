@ def number[_: P]: P[Int] = P(
    "zero" | "one" | "two" | "three" | "four" |
    "five" | "six" | "seven" | "eight" | "nine"
  ).!.map{
    case "zero"  => 0; case "one"   => 1 case "two"   => 2; case "three" => 3
    case "four"  => 4; case "five"  => 5 case "six"   => 6; case "seven" => 7
    case "eight" => 8; case "nine"  => 9
  }
