#! /usr/bin/python

from pyspark import SparkContext

sc = SparkContext("local[*]", "Lab10")

logfile = "/loudacre/weblogs"
logs = sc.textFile(logfile)

htmllogs = logs.filter(lambda line: ".html" in line).map(lambda line: line.split()).map(lambda line: line[0] + "/" +line[2])
htmllogs.take(5)
