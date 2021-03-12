package index;
import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IndexMapper extends Mapper<Text, Text, NullWritable, Put> {

  @Override
  public void map(Text key, Text value, Context context) throws IOException,
      InterruptedException {

    /*
     * TODO implement
     */
    
  }
}