"""
"""
class codeFightsArrays:
    """
    PROBLEM: firstDuplicate
    DESCRIPTION: ...
    SOLUTION 1
    """
    def firstDuplicate(self, a):
        mySet = set()
        for el in a:
            if el in mySet:
                return el
            mySet.add(el)
        return -1

    # SOLUTION 2 #
    def firstDuplicate(self, a):
        for i in a:
            if (a[abs(i) - 1] < 0):
                return abs(i)
            a[abs(i) - 1] *= -1
        return -1


    """
    PROBLEM: firstNotRepeatingCharacter
    DESCRIPTION: ...
    SOLUTION 1
    """
    def firstNotRepeatingCharacter(self, s):
        for i in s:
            if s.index(i) == s.rindex(i):
                return i
        return '_'

    # SOLUTION 2 #
    def firstNotRepeatingCharacter2(self, s):
        chk = []
        for i in range(len(s)):
            if s[i] not in s[i + 1:] and s[i] not in chk:
                return s[i]
            chk.append(s[i])
        return '_'


class testing:
    test1 = codeFightsArrays()
    test2 = codeFightsArrays()
    print(test1.firstNotRepeatingCharacter("POTATOP1"))
    print(test2.firstNotRepeatingCharacter2("PITITIP1"))