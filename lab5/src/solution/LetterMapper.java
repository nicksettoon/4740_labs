package solution;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    String line = value.toString();
    
    for (String word : line.split("\\W+")){
    	// get word length
    	int length = word.length();

    	if (length > 0) {
    		String firstletter= word.substring(0, 1);
        	// write to output
        	context.write(new Text(firstletter), new IntWritable(length));	
    	}
    }
  }
}
