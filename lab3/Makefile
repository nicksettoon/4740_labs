DIR=lab3

count: # counts number of lines each word occurs on
	#-make cleanall
	./commands.sh all
	hdfs dfs -cat ${DIR}/all-lines/part-r-00000 2> /dev/null

countpoems: # counts number of lines each word in shakespeare/poems occurs on
	#-make cleanpoems
	./commands.sh p poems
	hdfs dfs -cat ${DIR}/p-lines/part-r-00000 2> /dev/null

cleanpoems: # cleans the previous poem run
	hdfs dfs -rm -r ${DIR}/p-lines
	
cleanall: # cleans the prevoius normal run
	hdfs dfs -rm -r ${DIR}/all-lines

cleanlab: # cleans entire directory
	hdfs dfs -rm -r ${DIR}

list: # displays this makefile
	cat ./Makefile
