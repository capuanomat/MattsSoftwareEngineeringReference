"""
 This file contains a bunch of useful things and tests I ran while initially learning python
"""

a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(zip(*a))



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
dictio1 = {"Matthieu": "Capuano", "Celina": "Lui", 1 : "Value from key int 1", 2 : "Value from key int 2"}
print(dictio1["Matthieu"])
print(dictio1[1])

dictio2 = {}
dictio2["Key 1"] = 1
dictio2["Key 2"] = 2
dictio2[3] = "Value 3"

print(dictio2[3])

"""
====== OTHER ======
"""
l = [x for x in range (10)]
print(l)
print(list(range(5, 0, -1)))
print(list(range(1, 8, 3)))

print('-------------')
print(True or False) and (False or not False)