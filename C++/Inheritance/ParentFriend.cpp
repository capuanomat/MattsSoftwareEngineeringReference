/**
 * Created by Matthieu J. Capuano on 19/06/2021.
 */

#include "Parent.h"
#include <iostream>

/**
 * You can define this entire class as a friend of Parent (in the Parent.h), and
 * then this class will have access to private class variables from Parent
 * instances it creates.
 */
class ParentFriend {
public:
    static void accessPrivateDataFromFriend() {
        std::cout << "\nCalled ParentFriend::accessPrivateDataFromFriend()" << std::endl;
        Parent parent("Original parent string 1.", 100);

        std::cout << parent.privateString << std::endl;
        parent.privateString = "I can redefine it!";
        std::cout << parent.privateString << std::endl;
    }

    static void accessPrivateDataGivenParent(Parent& parent) {
        std::cout << "Called ParentFriend::accessPrivateDataGivenParent(Parent parent&)" << std::endl;

        std::cout << parent.privateString << std::endl;
        parent.privateString = "I can redefine it too too!";
        std::cout << parent.privateString << std::endl;
    }

    static void accessProtectedDataGivenParent(Parent& parent) {
        std::cout << "Called ParentFriend::accessProtectedDataGivenParent(Parent parent&)" << std::endl;

        std::cout << parent.protectedString << std::endl;
        parent.protectedString = "Defining a protected string from friend!";
        std::cout << parent.protectedString << std::endl;

    }
};

int main() {
    std::cout << "----- Starting the main function: PARENTFRIEND -----" << std::endl;

    // You can use friend classes to handle private fields of another class:
    ParentFriend::accessPrivateDataFromFriend();

    std::cout << std::endl;

    Parent parent("Creating a parent.", 102);

    // You cannot touch private variables of Parent from here:
    // parent.privateString = "This should not work";   // FAILS

    // However, you can pass them to a class that is a friend of Parent to handle it
    ParentFriend::accessPrivateDataGivenParent(parent);

    std::cout << std::endl;

    // You cannot touch protected variables of Parent from here either:
    // parent.protectedString = "Setting the protected string.";    // FAILS
    ParentFriend::accessProtectedDataGivenParent(parent);

    return 0;
}
