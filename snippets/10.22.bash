$ find post -type f
post/1 - My First Post.md
post/3 - My Third Post.md
post/2 - My Second Post.md

$ ./mill show dist
"ref:b33a3c95:/Users/lihaoyi/Github/blog/out/dist/dest"

$ find out/dist/dest -type f
out/dist/dest/index.html
out/dist/dest/post/my-first-post.html
out/dist/dest/post/yet-another-post.html
out/dist/dest/post/second-blog-post.html
