$ mkdir resources

$ echo "# title" > resources/foo.md

$ echo "print(123)" > resources/thing.py

$ find . -type f | grep -v out
.
./build.sc
./mill
./resources/foo.md
./resources/thing.py
./src/cow.txt
./src/iweigh.txt
./src/hello.txt
