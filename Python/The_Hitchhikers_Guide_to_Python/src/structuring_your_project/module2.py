
print("----- Start of module2.py -----")

str1 = "module2.str1"
print(str1)

# print(module1.str1)       # This would throw an error because we haven't imported module1 yet

import module1              # Note how were' just importing the namespace module1, so it doesn't override our local str1
print(str1)
print(module1.str1)
module1.str1 = "module1.str1 modified by module2"    # However, we can modify the sr1 from module1, even from module2
print(module1.str1)

import module1              # Re-importing module1 (not sure why you'd do that, just testing it out), doesn't actually
print(module1.str1)         # do anything lol

from module1 import str1    # However, importing str1 (or just importing *) overrides our local string
print(str1)                 # This was overwritten
print(module1.str1)

print("----- End of module2.py -----")
