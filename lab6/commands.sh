#! /bin/bash

dir="lab6"
ex="$1"
srcdir="shakespeare/$3"
jar="./toolrunner.jar"

hdfs dfs -mkdir "$dir" 2> /dev/null

if [ $ex == "d" ]
then
	echo "counting words via toolrunner. caseSensitive=DEFAULT"
	hadoop jar $jar tool.WordCount $srcdir "$dir/toolrunnerout_d"
fi

if [ $ex == "t" ]
then
	echo "counting words via toolrunner. caseSensitive=TRUE"
	hadoop jar $jar tool.WordCount -D caseSensitive=true $srcdir "$dir/toolrunnerout_t"
fi

if [ $ex == "f" ]
then
	echo "counting words via toolrunner. caseSensitive=FALSE"
	hadoop jar $jar tool.WordCount -D caseSensitive=false $srcdir "$dir/toolrunnerout_f"
fi
