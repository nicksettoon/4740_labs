#! /bin/bash

dir="lab4"
ex="$1"
srcdir="shakespeare/$3"
jar="../wc_filter.jar"

cd ./shakespeare

hdfs dfs -mkdir "$dir" 2> /dev/null

if [ $ex == "1" ]
then
	echo "counting all capitalized words"
	hadoop jar $jar solution.WordCount $srcdir "$dir/$2-count-filtered" 2> /dev/null
fi

if [ $ex == "2" ]
then
	echo "listing capitalized word counts greater than 10"
	hadoop jar $jar solution.WordCountEx2 $srcdir "$dir/$2-count-filtered-gt-10" 2> /dev/null
fi
