package solution;
import java.io.IOException;
import java.util.Collection;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

	  int sum = 0;
	  int num = 0;
	  
	  for (IntWritable value : values) {
		  sum += value.get();
		  num++;
	  }
	  
	  context.write(key, new DoubleWritable((double)sum/(double)num));
  }
}