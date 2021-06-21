/**
 * Created by Matthieu J. Capuano on 17/06/2021.
 */

#include "Parent.h"

Parent::Parent() {
    std::cout << "Parent() constructor called." << std::endl;
    this->privateString = "Nothing passed in to parent.";
    this->privateInt = 0;
}

Parent::Parent(const std::string& privateString, int privateInt) {
    std::cout << "Parent(string&, int) constructor called." << std::endl;
    this->privateString = privateString;
    this->privateInt = privateInt;
}

std::string Parent::toString() const {
    return this->publicString + " - "  + this->privateString + " - " + std::to_string(this->privateInt);
}

void Parent::setPrivateString(const std::string& privateString) {
    this->privateString = privateString;
}

std::string Parent::getPrivateString() const {
    return this->privateString;
}

void Parent::setPrivateInt(int privateInt) {
    this->privateInt = privateInt;
}

int Parent::getPrivateInt() const {
    return this->privateInt;
}
