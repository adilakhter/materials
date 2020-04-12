@ ctx.run(query[City].filter(_.name.length == 1))
cmd25.sc:1: Tree 'x$1.name.length()' can't be parsed to 'Ast'
val res25 = ctx.run(query[City].filter(_.name.length == 1))
                                      ^
Compilation Failed
