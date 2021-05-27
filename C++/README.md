# C++ Quick Notes


## How I learned C++ (Key References)
- Daniel Liang's Book: Introdution to Programming with C++ (2014)
- USC CS 102: Fundamentals of Computing: https://bytes.usc.edu/cs102
- USC CS 103: Introduction to Programming: https://bytes.usc.edu/cs103
- Steven Skiena's Analysis of Algorithms (also good for interview Prep): https://www3.cs.stonybrook.edu/~skiena/373/videos/


## Debugging with GDB
First, compile your code: `g++ --std=c++14 <fileName>.cpp -o <someOutputName>`
Then execute it with `gdb ./<someOutputName>`
- Stop the program at line number `n` by specifying (ahead of time) `break n`
- Then run until a break is hit with `run`
- To step and execute one line at a time (will go into the function): `step`
- If you get to a line with a function call you don't want to go into but have to execute (step-over): `next`
- You can print a variable or expression at any time: `print size`, `print nums[i]`, `print nums[i] == target`, etc.
- Gdb has a text-based UI ("TUI"), to see bouth source code and debugger command area:
    - To turn on src display: `layout src`
    - To turn off src display: `tui disable`
    - You can toggle between them with Ctrl-X, a
    - To move your cursor between the windows: Ctrl-X, o






### Pass by Value vs. Pass by Reference
- Reference: https://www.cs.fsu.edu/~myers/c++/notes/references.html
- ...

### decltype
- decltype is a keyword that allows you to find the type of an expression
- Reference: https://en.wikipedia.org/wiki/Decltype
- Reference: https://en.cppreference.com/w/cpp/language/decltype


### Passing strings into Functions
- Reference: https://stackoverflow.com/questions/4475634/c-pass-a-string
- If you’re passing a string into a function, the function header should read in a `const std::string&` as the type

### Tuples
- Reference: https://www.geeksforgeeks.org/tuples-in-c/
- C++ tuples can hold multiple elements (not just 2) of different data types
- They are initialized as arguments in order in which they will be accessed
- Operations on Tuples
    - get(): To access the tuple values and modify them, accepts the index and tuple name as arguments
        - Note that the get() method is in std::
        - You can get by either index or type: https://en.cppreference.com/w/cpp/utility/tuple/get
    - make_tuple(): to assign tuple with values
        - The values passed need to be in the order with the values declared in tuple

`
#include<iostream>
#include<tuple> // for tuple
using namespace std;
int main()
{

    // Declaring tuple
    tuple <char, int, float> geek;

    // Assigning values to tuple using make_tuple()
    geek = make_tuple('a', 10, 15.5);

    // Printing initial tuple values using get()
    cout << "The initial values of tuple are : ";
    cout << get<0>(geek) << " " << get<1>(geek);
    cout << " " << get<2>(geek) << endl;

    // Use of get() to change values of tuple
    get<0>(geek) = 'b';
    get<2>(geek) =  20.5;

     // Printing modified tuple values
    cout << "The modified values of tuple are : ";
    cout << get<0>(geek) << " " << get<1>(geek);
    cout << " " << get<2>(geek) << endl;

    return 0;
}
`
#### output:
`
The initial values of tuple are : a 10 15.5
The modified values of tuple are : b 10 20.5
`

- tuple_size(): Returns number of elements present in the tuple
tuple <char,int,float> geek(20,'g',17.5);
cout << "The size of tuple is : ";
cout << tuple_size<decltype(geek)>::value << endl;

#### output:
The size of tuple is :
swap(): swaps the elements of the two different tuples
