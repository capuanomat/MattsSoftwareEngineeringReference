""""""
class codeFightsArrays:
    """"""
    """
    PROBLEM: firstDuplicate
    NOTE: O(n) time, O(1) space
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
    NOTE: Iterate through string once, O(1) space
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


    """
    PROBLEM: rotateImate
    NOTE: O(1) Space
    DESCRIPTION: Rotate a 2D matrix by 90 degrees clockwise...
    SOLUTION 1: Something similar to how I did it in Java, just reverse by main diagonal and then flip 
                horizontally
    """

    # SOLUTION 2 #
    def rotateImage2(self, a):
        return [[x[i] for x in a][::-1] for i in range(len(a))]

    # SOLUTION 3 #
    def rotateImage3(a):
        return list(zip(*reversed(a)))

    # OTHER USEFUL 2D ARRAY MANIPULATIONS
    def manipulateMatrix(self, a):
        print([x for x in a])                                       # This much prints the three rows in order
        print([x for x in a][::-1])                                 # This prints the three rows in reverse order
        print([[x[i] for x in a] for i in range(len(a))])           # Transposes matrix about the main diagonal
        print([[x[i] for x in a][::-1] for i in range(len(a))])             # Rotates matrix 90 degrees CW
        print([[x[i] for x in a] for i in range(len(a) - 1, -1, -1)])       # Rotates matrix 90 degrees CC
        print([[x[i] for x in a][::-1] for i in range(len(a) - 1, -1, -1)]) # Transposes matrix about off diagonal
        # This may require explanation: Take the fourth print statement above, what it says is, for i being equal
        #                               to 0, 1, 2, ... you take element x[i] of each row and make a new row out
        #                               of those. So take x[0] in the first row, then x[0] in the second row, etc.
        #                               It takes x[0] in each row because "for x in a" goes through each row.
        #                               The [::-1] says to take this newly created row (list) and reverse it.
        #                               Then repeat for the rest

    # https://www.youtube.com/watch?v=Rlak6CTcUDI
    def  manipulateMatrix2(self, a):
        print(reversed(a))          # This will print an iterator for a that iterates in reverse order
        print(*reversed(a))         # This will iterate through the iterator and print everything
        print(zip(*reversed(a)))    # This .............?

    """
    PROBLEM: sudoku2
    DESCRIPTION: Check if a 2D grid representing a starting sudoku is a valid sudoku...
    EXAMPLES:
    """
    def sudoku2(self, grid):
        for row in grid:
            st = set()
            for i in row:
                if i in st and i is not '.':
                    return False
                else:
                    st.add(i)

        trans = [[x[i] for x in grid] for i in range(len(grid))]
        for col in trans:
            st = set()
            for i in col:
                print(st)
                if i in st and i is not '.':
                    return False
                else:
                    st.add(i)

        for k1 in range(0, 9, 3):  # The 8 and 3 are harcoded for a 9x9
            for k2 in range(0, 9, 3):
                st = set()
                for i in range(k1, k1 + 3):  # Also some hardcoding here and below
                    for j in range(k2, k2 + 3):
                        if grid[i][j] in st and grid[i][j] is not '.':
                            return False
                        else:
                            st.add(grid[i][j])

        return True

    """
    PROBLEM: isCryptSolution
    DESCRIPTION: ...
    EXAMPLE: ...
    """
    # SOLUTION 1 - My Solution#
    def isCryptSolution(crypt, solution):
        # This Solution scales for crypt.length > 3 and crypt[i].length > 14
        zeroLetter = ''
        letters = {}
        for row in solution:
            letters.update({row[0]: row[1]})
            if row[1] is '0':
                zeroLetter = row[0]

        # Left Side of Equation
        leftOK = True
        leftAllZeros = True
        sumLeft = 0
        for i in range(len(crypt) - 1):
            word = crypt[i]
            if (word[0] is zeroLetter) and (len(word) != 1):
                leftOK = False
            elif (word[0] is not zeroLetter):
                leftAllZeros = False
                for j in range(0, len(word)):
                    c = word[j]
                    sumLeft += int(letters[c]) * math.pow(10, len(word) - j - 1)

        # Right Side of Equation
        word = crypt[len(crypt) - 1]
        rightOK = True
        sumRight = 0
        if ((len(word) > 1) and (word[0] is zeroLetter)):
            rightOK = False
        else:
            for j in range(0, len(word)):
                c = word[j]
                sumRight += int(letters[c]) * math.pow(10, len(word) - j - 1)
        return (leftOK or leftAllZeros) and (rightOK) and \
               (sumLeft == sumRight)

    # SOLUTION 2 - Top Solution #
