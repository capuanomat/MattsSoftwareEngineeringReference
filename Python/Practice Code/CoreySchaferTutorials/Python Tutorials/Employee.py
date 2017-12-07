"""
Based on tutorials from: https://www.youtube.com/watch?v=ZDa-Z5JzLYM
TOPIC: Classes and Instances, Class Variables, Class Methods and Static Methods, Inheritance, Special (Magic/Dunder)
       Methods, Property Decorators
"""
class Employee:

    num_of_emps = 0         # This is an example of a variable that you wouldn't want to change for individual
                            # employees
    raise_amount = 1.04     # This variable is common among all instances of Employee

    def __init__(self, first, last, pay):
        # All instances of Employee have the variables below but their values are instance specific
        self.first = first
        self.last = last
        self.pay = pay
        self.email = first + '.' + last + '@company.com'

    def fullName(self):
        return '{} {}'.format(self.first, self.last)    # {} acts as a place holder when formating the string

    def applyRaise(self):
        self.pay = int(self.pay * self.raise_amount)    # You MUST do self.staticVar or className.staticVar to
                                                        # access a common variable like raise_amount, so you
                                                        # could also do Employee.raise_amount but the raise_amount
                                                        # of a specific instance might have been changed from the
                                                        # Employee one





emp_1 = Employee('Matthieu', 'Capuano', 500000)
emp_2 = Employee('Test', 'User', 150000)





# The print statements below explain some important concepts, comment them out at will for clarity
"""
print("PRINTING USING __dic__")
print(Employee.__dict__)
print(emp_1.__dict__)           # IMPORTANT: Prints out all attributed of emp_1


print("INITIAL RAISE AMOUNTS:")
print(Employee.raise_amount)
print(emp_1.raise_amount)       # Printing a static variable from instance will check for it in the instance first
print(emp_2.raise_amount)       # if the instance doesn't have the variable, then it checks the class itself
                                # (Employee in this case)

Employee.raise_amount = 1.05
print("RAISE AMOUNTS AFTER Employee.raise_amount = 1.05:")
print(Employee.raise_amount)
print(emp_1.raise_amount)
print(emp_2.raise_amount)

emp_1.raise_amount = 1.06
print("RAISE AMOUNTS AFTER emp_1.raise_amount = 1.06:")
print(Employee.raise_amount)
print(emp_1.raise_amount)        # So now if you applied emp_1.applyRaise(), it would use 1.06 instead of 1.05
print(emp_2.raise_amount)

Employee.raise_amount = 1.07
print("RAISE AMOUNTS AFTER Employee.raise_amount = 1.07:")
print(Employee.raise_amount)
print(emp_1.raise_amount)
print(emp_2.raise_amount)
"""
