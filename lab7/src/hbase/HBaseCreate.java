package hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;


public class HBaseCreate {

	public static void main(String[] args) throws IOException {
		//SETUP HBASE CONNECTION
		Configuration config = HBaseConfiguration.create();
		Connection connection = ConnectionFactory.createConnection(config);
		Admin admin = connection.getAdmin();
		
		try {
			admin.disableTable(TableName.valueOf("courses"));
			admin.deleteTable(TableName.valueOf("courses"));
			HTableDescriptor courses = new HTableDescriptor(TableName.valueOf("courses"));
			HColumnDescriptor info = new HColumnDescriptor("info");
			HColumnDescriptor instructors = new HColumnDescriptor("instructors");

			courses.addFamily(info);
			courses.addFamily(instructors);

			admin.createTable(courses);
		} finally {
			admin.close();
			connection.close();
		}
	}

}
