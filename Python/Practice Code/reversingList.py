"""
====== REVERSING A LIST ======
"""
# https://www.youtube.com/watch?v=sGhY8dQdu4A

myList = [1, 2, 3, 4, 5]
print(myList)
print(myList.reverse())     # Reverses in-place

reversed1 = myList[::-1]    # Reverses out-of-place
print(reversed1)

reversed2 = list(reversed(myList))  # Creates a list from an iterator for myList in reverse order

"""
====== DICTIONARY STUFF ======
"""
class hi:
    a = {"Matt": 1000000, "Celina": 500000, "Test1": 200000, "Test2": 150000}
    print a["Matt"]

