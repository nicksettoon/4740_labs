
count:
	-make cleanall
	./commands.sh all

countpoems:
	-make cleanpoems
	./commands.sh p poems

cleanpoems:
	hdfs dfs -rm -r lab3/p-lines
	
cleanall:
	hdfs dfs -rm -r lab3/all-lines

cleanlab:
	hdfs dfs -rm -r lab3
