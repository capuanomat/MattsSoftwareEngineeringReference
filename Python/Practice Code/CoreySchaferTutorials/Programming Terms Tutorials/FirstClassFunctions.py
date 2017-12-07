"""
TUTORIAL ON FIRST - CLASS FUNCTIONS: https://www.youtube.com/watch?v=kr0mpwqttM0&feature=youtu.be

•	Important to understand things like Higher – order functions, currying?, and closures
•	From the Wikipedia definitions, we can deduce that a First Class Function is one that is treated as a
    “First class Citizen”, meaning it can be passed as an argument, returned from a function, and assigned to a
    variable
•	Example:
"""
def square(x):
    return x * x

f1 = square(5)
f2 = square

print(square)   # Prints function signature
print(f1)       # Prints 25
print(f2)       # Prints function signature
print(f2(5))    # Prints 25

"""
•	Functions can also be passed in as arguments and returned from other functions
    o	Those are called higher order functions (if they take in or return functions)
•	Example:
"""
def cube(x):
    return x * x * x

def my_map(func, arg_list):     # my_map takes in a function and list of arguments, and then returns a list with
                                # the function applied to all arguments
    result = []
    for i in arg_list:
        result.append(func(i))
    return result

squares = my_map(square, [1, 2, 3, 4, 5])
print(squares)
cubes = my_map(cube, [1, 2, 3, 4, 5])
print(cubes)


"""
•	You can also return functions from functions:
"""
def logger(msg):
    def log_message():
        print('Log:', msg)

    return log_message          # Be careful to return log_message (the actual function) and NOT log_message() (a
                                # call to the function). TRY RETURNING log_message() INSTEAD TO SEE WHAT HAPPENS

log_hi = logger('Hi!')          #log_hi is now equal to log_message, with msg set to 'Hi!'
log_hi()

"""
•	An example of how this could be useful (not included in Word Doc):
"""
def html_tag(tag):
    def wrap_text(msg):
        print('<{0}>{1}</{0}>'.format(tag, msg))

    return wrap_text

print_h1 = html_tag('h1')
print_h1('Test Headline!')
print_h1('Another Headline!')

print_p = html_tag('p')
print_p('Test Paragraph!')
