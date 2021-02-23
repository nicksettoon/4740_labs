DIR=lab6

all: # displays this file
	cat ./Makefile

default: # counts words with no runtime arguments
	-make cleand 2> /dev/null
	./commands.sh d

true: # counts words with no runtime arguments
	-make cleant 2> /dev/null
	./commands.sh t

false: # counts words with no runtime arguments
	-make cleanf 2> /dev/null
	./commands.sh f

cleand: # cleans up previous default run
	hdfs dfs -rm -r ${DIR}/toolrunnerout_d 2> /dev/null

cleanf: # cleans up previous false run
	hdfs dfs -rm -r ${DIR}/toolrunnerout_f 2> /dev/null

cleant: # cleans up previous true run
	hdfs dfs -rm -r ${DIR}/toolrunnerout_t 2> /dev/null

printd: # prints output of last default run
	hdfs dfs -cat ${DIR}/lab6/toolrunnerout_d/part-r-00000 2> /dev/null

printt: # prints output of last true run
	hdfs dfs -cat ${DIR}/lab6/toolrunnerout_t/part-r-00000 2> /dev/null

printf: # prints output of last false run
	hdfs dfs -cat ${DIR}/lab6/toolrunnerout_f/part-r-00000 2> /dev/null

cleanlab: # cleans all runs
	hdfs dfs -rm -r ${DIR} 2> /dev/null

