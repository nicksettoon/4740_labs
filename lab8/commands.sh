#! /bin/bash
srcdir="shakespeare"
dir="lab2"

hdfs dfs -mkdir lab2

cd ./shakespeare

for f in *; do
	echo "calculating word count for shakespeare/$f"
	hadoop jar ../wc.jar solution.WordCount "$srcdir/$f" "$dir/$f-words" 2> /dev/null
	outdir="$dir/$f-words"
	count=$(hdfs dfs -cat "$outdir/part-r-00000" 2> /dev/null| wc -l)
	echo "Unique words in $f: $count"
done

cd ..
echo "calculating total word count"
hadoop jar wc.jar solution.WordCount $srcdir $dir/all-words 2> /dev/null
allcounts=$(hdfs dfs -cat "$dir/all-words/part-r-00000" | wc -l)
echo "Unique words in all shakespeare files: $allcounts"

#for f in *; do
	#hdfs dfs -cat "$outdir/part-r-00000" | sed 's/\(^\t\).*/\1/' >> ../all-words
	#allcounts=$(cat ../all-words | wc -l)
	#echo "all-words length: $allcounts"
#done

#hdfs dfs -put ./all-words lab2/
#hadoop jar wc.jar solution.WordCount lab2/all-words lab2/all-counts
#allcounts=$(hdfs dfs -cat "lab2/all-counts/part-r-00000" | wc -l)


