#! /usr/bin/python

# Stub code to copy into Spark Shell (use Control C & V)
import xml.etree.ElementTree as ElementTree
# Given a string containing XML, parse the string, and
# return an iterator of activation XML records (Nodes)
# contained in the string

def getactivations(s):
    filetree = ElementTree.fromstring(s)
    return filetree.getiterator('activation')
    # Given an activation record (XML Node), return the model name

def getmodel(activation):
    return activation.find('model').text
    # Given an activation record (XML Node), return the account number

def getaccount(activation):
    return activation.find('account-number').text

activationFiles = sc.wholeTextFiles("/loudacre/activations")

activationRecords = activationRecords.flatMap(lambda x: getactivations(x[1]))

models = activationRecords.map(lambda line: getaccount(line) + ":" + getmodel(line))

# for line in models.collect():
#     print(line)

models.saveAsTextFile("/loudacre/account-models")