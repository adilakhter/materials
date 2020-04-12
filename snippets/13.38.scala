def fetchAllLinksAsync(startTitle: String, depth: Int): Future[Set[String]] = {
  def rec(current: Set[String], seen: Set[String], recDepth: Int): Future[Set[String]] = {
    if (recDepth >= depth) Future.successful(seen)
    else {
      val futures = for(title <- current) yield fetchLinksAsync(title)
      Future.sequence(futures).map{nextTitleLists =>
        rec(
          nextTitleLists.flatten.filter(!seen.contains(_)),
          seen ++ nextTitleLists.flatten,
          recDepth + 1
        )
      }.flatten
    }
  }
  rec(Set(startTitle), Set(startTitle), 0)
}
