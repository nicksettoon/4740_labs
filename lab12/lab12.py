#! /usr/bin/python

logs = sc.textFile("/loudacre/weblogs/*")

################### EXERCISE 1 ##############
userReqs = logs.map(lambda line: (line.split(" ")[2], 1))

# # get number of users
# print(len(userReqs.countByKey().keys()))

# reduce number of requests per user
numReqs = userReqs.reduceByKey(lambda v1, v2: v1+v2)

################### EXERCISE 2 ###############
numReqs.map(lambda pair: (pair[1], pair[0])).countByKey()

################### EXERCISE 3 ###############
# load account data from file and reorganize into Pair RDD
accountData = sc.textFile("/loudacre/accounts/part*").map(lambda line: line.split(",")).map(lambda account: (account[0], account[1:]))

# join Pair RDDs
accountHits = accountData.join(numReqs)

# map RDD to output string RDD
accountHitsDisplay = accountHits.map(lambda (userid, (values, count)): userid + "," + str(count) + "," + values[2] + "," + values[3])

# print each account
for account in accountHitsDisplay.collect():
    print(account)
