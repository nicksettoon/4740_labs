DIR=lab4

countex1: # capitalizes all words and lists their counts
	#-make cleanex1 2> /dev/null
	./commands.sh 1 all
	hdfs dfs -cat lab4/all-count-filtered/part-r-00000 2> /dev/null

countex2: # lists all capitalized words which occur more than 10 times
	#-make cleanex2 2> /dev/null
	./commands.sh 2 all
	hdfs dfs -cat lab4/all-count-filtered-gt-10/part-r-00000 2> /dev/null

cleanex1: # cleans up previous run
	hdfs dfs -rm -r ${DIR}/all-count-filtered 2> /dev/null

cleanex2: # cleans up previous run
	hdfs dfs -rm -r ${DIR}/all-count-filtered-gt-10 2> /dev/null

cleanlab: # cleans all runs
	hdfs dfs -rm -r ${DIR} 2> /dev/null

list: # displays this file
	cat ./Makefile
