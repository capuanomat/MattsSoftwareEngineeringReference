"""
TUTORIAL ON CLOSURES: https://www.youtube.com/watch?v=swU3c34d2NQ&feature=youtu.be
NOTE: Read the FirstClassFunctions.py document first

•	A closure seems to be that a variable defined in an outer function but used in an inner function is accessible to
    the inner function even AFTER it has been returned
    o	So if your outer function returns the inner function, and that inner function uses a variable defined in the
        outer function, then the fact that the inner function can still use it makes this a closure
"""
def outer_func(msg):
    message = msg
    def inner_func():
        print(message)      # Note: you could just remove the message = msg line and do print(msg) here

    return inner_func       # Returning inner_func() would actually call the inner_func() and print the message

hi_func =outer_func('Hi!')
hello_func = outer_func('Hello!')
print(hi_func)              # Prints the function signature
print(hi_func.__name__)     # Prints just the name of the function

hi_func()
hi_func()
hello_func()
hello_func()
hello_func()                # Run this script and notice that hi_func and hello_func remember their msg variable even
                            # though it was defined OUTSIDE their scope, that's what a closure is

"""
•	The last example in the First Class Functions tutorial (in .py file but not in doc is also a good example of closure)
•	The .py file also contains a more complex example that creates a log file every time the returned function is 
    called
"""
import logging
logging.basicConfig(filename='example.log', level=logging.INFO)

def logger(func):
    def log_func(*args):
        logging.info(
            'Running "{}" with arguments {}'.format(func.__name__, args))
        print(func(*args))
    return log_func


def add(x, y):
    return x+y


def sub(x, y):
    return x-y

add_logger = logger(add)
sub_logger = logger(sub)

add_logger(3, 3)
add_logger(4, 5)

sub_logger(10, 5)
sub_logger(20, 10)