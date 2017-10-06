class test:
    def amethod(inp):
        if inp > 10:
            print "inp is greater than 10"
        if inp == 10:
            print "inp is 10"
        if inp < 10:
            print "inp is smaller than 10"
    print "OMG DOES IT WORK???"
    print "WHAT IF I MAKE A CHANGE???"
    x = 10
    amethod(x)
    amethod(15)

    dictio = {}
    dictio["Kimberly"] = 9999
    dictio["Linh"] = 8888
    dictio[1000] = "Selene"

    print dictio[1000]
