#! /bin/bash

dir="lab5"
ex="1"
srcdir="shakespeare/$3"
jar="../avglength.jar"

cd ./shakespeare

hdfs dfs -mkdir "$dir" 2> /dev/null

if [ $ex == "1" ]
then
	echo "calculating average word length"
	hadoop jar $jar solution.AvgWordLength $srcdir "$dir/$2-avg-word-length"
fi
