@ var total = 0

@ for(i <- Range(0, 10)) {
    total += (if (i % 2 == 0) i else 2)
  }

@ total
res97: Int = 30
