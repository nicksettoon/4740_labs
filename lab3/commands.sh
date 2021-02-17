#! /bin/bash

dir="lab3"
srcdir="shakespeare/$2"
jar="../lc.jar"

cd ./shakespeare

hdfs dfs -mkdir "$dir" 2> /dev/null

hadoop jar $jar solution.WordCount $srcdir "$dir/$1-lines"
