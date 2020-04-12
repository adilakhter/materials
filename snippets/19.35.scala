@ fastparse.parse("three times seven", parser(_))
res81: Parsed[Int] = Success(21, 38)

@ fastparse.parse("five times ((nine times eight) minus four)", parser(_))
res83: Parsed[Int] = Success(340, 42)
