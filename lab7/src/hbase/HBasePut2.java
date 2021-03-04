package hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HBasePut2 {

	public static void main(String[] args) throws IOException {
		Configuration config = HBaseConfiguration.create();
		Connection connection = ConnectionFactory.createConnection(config);
		Table table = connection.getTable(TableName.valueOf("courses"));

		try {
			// create course rows
			Put cs3501 = new Put(Bytes.toBytes("CS3501"));
			Put cs4740 = new Put(Bytes.toBytes("CS4740"));
			Put cs4998 = new Put(Bytes.toBytes("CS4998"));
			Put cs7402 = new Put(Bytes.toBytes("CS7402"));

			byte[] info = Bytes.toBytes("info");
			byte[] name = Bytes.toBytes("name");
			byte[] credit = Bytes.toBytes("credit");
			byte[] since = Bytes.toBytes("since");

			byte[] instructors = Bytes.toBytes("instructors");
			byte[] s15 = Bytes.toBytes("2015S");
			byte[] s21 = Bytes.toBytes("2021S");

			cs3501.addImmutable(info, name, Bytes.toBytes("comp. org."));
			cs3501.addImmutable(info, credit, Bytes.toBytes("3"));

			cs4740.addImmutable(info, name, Bytes.toBytes("big data"));
			cs4740.addImmutable(info, credit, Bytes.toBytes("3"));
			cs4740.addImmutable(info, since, Bytes.toBytes("2015"));

			cs4740.addImmutable(instructors, s15, Bytes.toBytes("Wang"));
			cs4740.addImmutable(instructors, s21, Bytes.toBytes("Lee"));

			cs4998.addImmutable(info, credit, Bytes.toBytes("1"));

			cs7402.addImmutable(info, name, Bytes.toBytes("DB"));
			cs7402.addImmutable(info, credit, Bytes.toBytes("3"));

			cs7402.addImmutable(instructors, s21, Bytes.toBytes("TBA"));

			table.put(cs3501);
			table.put(cs4740);
			table.put(cs4998);
			table.put(cs7402);

		} finally {
			table.close();
			connection.close();
		}

	}

}
