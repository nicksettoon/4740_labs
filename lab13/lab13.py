## 4740 lab 13
## author Nicklaus Settoon

## EXERCISE 1 ##
rawData = sc.textFile("/loudacre/accounts/*")
accountsByPostal = rawData.map(lambda x: x.split(",")).keyBy(lambda x: x[8])

## EXERCISE 2 ##
namesInPostal = accountsByPostal.mapValues(lambda x: "{},{}".format(x[4], x[3])).groupByKey()

for (postal,names) in namesInPostal.collect():
    print "{}:".format(postal)
    for name in names:
        print "\t{}".format(name)


## EXERCISE 3 ##
sortedNamesInPostal = namesInPostal.sortByKey()

for code,names in sortedNamesInPostal.take(2):
    print "---{}".format(code)
        for name in names:
            print "{}".format(name)

## EXERCISE 4 ##
sortedNamesInPostal.persist()

for code,names in sortedNamesInPostal.take(2):
    print "---{}".format(code)
        for name in names:
            print "{}".format(name)
