/**
 * Created by Matthieu J. Capuano on 18/06/2021.
 */
 
#ifndef CHILDONE_H
#define CHILDONE_H

#include "Parent.h"

class ChildOne : public Parent {
public:
    ChildOne();
    ChildOne(const std::string& someString, int someInt);

private:
    std::string privateChildString;
    int privateChildInt;
};

#endif
