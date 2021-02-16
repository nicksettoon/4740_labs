
count:
	./commands.sh

clean:
	-make cleanlab 2> /dev/null
	#-make cleanwords 2> /dev/null

cleanlab:
	-hdfs dfs -rm -r lab2 2> /dev/null

#cleanwords:
	#-rm ./all-words 2> /dev/null
	#-hdfs dfs -rm lab2/all-words 2> /dev/null
	#-hdfs dfs -rm -r lab2/all-counts 2> /dev/null
	#-hdfs dfs -rm -r lab2/all-count 2> /dev/null
