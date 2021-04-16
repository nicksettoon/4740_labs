from pyspark.sql import SQLContext
from pyspark.sql.functions import sum, avg, desc, asc, min, max

sqlCtx = SQLContext(sc)
#import data
df = sqlCtx.jsonFile("2015-summary.json")
# rename columns
df2 = df.withColumnRename("DESTINATION_COUNTRY_NAME", "dest").withColumnRename("ORIGIN_COUNTRY_NAME", "origin").withColumnRenamed("count", "cnt")

## EXCERCISE 1 ##
# prints top 5 destination countries aside from United States
df2.select("dest", "cnt").where("dest != 'United States'").orderBy(desc("cnt")).show(5)
 
 ## EXERCISE 2 ##
# same as exercise 1, but with SQL query syntax
df2.registerTempTable("flights")
sqlCtx.sql("select dest, cnt FROM flights WHERE dest <> 'United States' ORDER BY cnt").show(5)

## EXCERCISE 3 ##
