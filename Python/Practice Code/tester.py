class tester:
    def method(a, b, c, **options):
        print a
        print b
        print c
        if options.get("this") == "this":
            print "WOOHOO"

        if options.get("that") == "first":
            print "@@@@@@"

        print options
        print z
    method(1, 2, 3, this = "this", that = "first")
