@ val gitStatus = os.proc("git", "status").call()
gitStatus: os.CommandResult = CommandResult(
...

@ gitStatus.exitCode
res3: Int = 0

@ gitStatus.out.text()
res4: String = """On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

	new file:   post/37 - How to work with Subprocesses in Scala.md
...

@ gitStatus.err.text()
res5: String = ""
