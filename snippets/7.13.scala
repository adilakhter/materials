@ val githubPath = os.Path("/Users/lihaoyi/Github"); val usersPath = os.Path("/Users")

@ githubPath.relativeTo(usersPath)
res30: os.RelPath = lihaoyi/Github

@ usersPath.relativeTo(githubPath)
res31: os.RelPath = ../..
