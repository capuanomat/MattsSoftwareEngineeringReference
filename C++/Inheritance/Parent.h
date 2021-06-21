/**
 * Created by Matthieu J. Capuano on 17/06/2021.
 */

#ifndef PARENT_H
#define PARENT_H

#include <iostream>
#include <string>

class Parent {
public:
    Parent();
    Parent(const std::string& someString, int someInt);

    std::string toString() const;   // Const because function shouldn't modify anything.

    void setPrivateString(const std::string& privateString);
    std::string getPrivateString() const;  // Const because function shouldn't modify anything.

    void setPrivateInt(int privateInt);
    int getPrivateInt() const;     // Const because function shouldn't modify anything.

    friend class ParentFriend;  // Can define the whole class as friend so it can access privates

    // I don't *think* you can define individual functions within a class as friends, the below doesn't work:
    // friend void ParentFriend::accessPrivateFromParentFriend1();
    // friend void ParentFriend::passInParentDirectly(Parent& parent);

    std::string publicString;

protected:
    std::string protectedString;

private:
    std::string privateString;
    int privateInt;
};

#endif
