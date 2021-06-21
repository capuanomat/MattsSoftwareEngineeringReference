/**
 * Created by Matthieu J. Capuano on 18/06/2021.
 */

#include "ChildOne.h"

ChildOne::ChildOne() : Parent("Nothing passed in to child.", 0) {
    std::cout << "ChildOne() constructor called." << std::endl;
    // this->privateString = "Nothing passed in to child."; // FAILS, privateString is private to Parent
    // this->privateInt = 0;                                // FAILS, privateString is private to Parent

    // setPrivateString("Nothing passed in to child.");     // WORKS too
    // setPrivateInt(0);                                    // WORKS too
}

ChildOne::ChildOne(const std::string& privateString, int privateInt) : Parent(privateString, privateInt) {
    std::cout << "ChildOne(string&, int) constructor called." << std::endl;
    // this->privateString = privateString;    // FAILS, privateString is private to Parent
    // this->privateInt = privateInt;          // FAILS, privateString is private to Parent

    // setPrivateString(privateString); // WORKS, same effect as using initializer list above
    // setPrivateInt(privateInt);       // WORKS, same effect as using initializer list above
}
