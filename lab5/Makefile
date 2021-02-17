DIR=lab5

avglength: # calculates average word length for all files in shakespeare
	-make cleanavg 2> /dev/null
	./commands.sh 1 all
	hdfs dfs -cat ${DIR}/all-avg-word-length/part-r-00000 2> /dev/null

cleanavg: # cleans up previous run
	hdfs dfs -rm -r ${DIR}/all-avg-word-length 2> /dev/null

cleanlab: # cleans all runs
	hdfs dfs -rm -r ${DIR} 2> /dev/null

list: # displays this file
	cat ./Makefile
