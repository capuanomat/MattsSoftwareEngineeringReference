from B import *
from AHA import *
from AHA.D import *
import urllib
#print dir(b)

class a:
    that = b()
    help(that)
    dir(that)

    that2 = c()
    help(that2)

    dir(b)
    that = b()
    that.method1()

    this = c()
    this.method2c()

    that2 = d()
    that2.methodd1()

    for x in xrange(10):
        if x%2 == 0:
            continue
        #print x

    sentence = "This is a test"
    words = sentence.split()
    #print words

    #if (2 != 3):
        #print "what???"
