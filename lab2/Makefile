DIR=lab2

count: # counts all the words in each file, then all the files and outputs their frequency
	./commands.sh

clean: # cleans stuff up from the previous run
	-make cleanlab 2> /dev/null
	#-make cleanwords 2> /dev/null

cleanlab: # cleans entire directory
	-hdfs dfs -rm -r ${DIR} 2> /dev/null

list: # displays this file
	cat ./Makefile

#cleanwords: # attempted to use sed to do some substitutions before running final MapReduce
	#-rm ./all-words 2> /dev/null
	#-hdfs dfs -rm lab2/all-words 2> /dev/null
	#-hdfs dfs -rm -r lab2/all-counts 2> /dev/null
	#-hdfs dfs -rm -r lab2/all-count 2> /dev/null
