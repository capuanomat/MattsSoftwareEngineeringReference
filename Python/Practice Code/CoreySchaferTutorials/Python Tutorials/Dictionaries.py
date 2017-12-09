student = {'Name': 'Matthieu', 'Age': 22, 'Courses': ['Jet and Rocket Propulsion', 'Intro to AI', 'Design and Analysis of Algorithms']}
print(student['Name'])
print(student['Courses'])

# You can add key-value pairs after the dictionary is already created:
student['Phone'] = 6781111111

# You can also edit the values:
student['Name'] = 'Matthew'

# If you want to edit/add multiple key-values at once:
student.update({'Name': 'Jean-Baptiste', 'Age': 23, 'Address' : 'North Ave North, Georgia Tech'})

print(student)
print(student.get('Name'))
print(student.get('KEY DOES NOT EXIST!'))
print(student.get('KEY DOES NOT EXIST!', 'THIS IS OUTPUT INSTEAD OF NONE IF THE KEY DOESN"T EXIST'))

# To delete a key value pair:
del student['Courses']
print(student)

# To delete a key value pair but retain the value:
number = student.pop('Phone')
print(number)

# Iterating through the keys and values
print(len(student))
print(student.keys())
print(student.values())
print(student.items())

for cur in student:     # This will only iterate through the keys
    print(cur)

print('----------')

for key, value in student.items():
    print(key, value)