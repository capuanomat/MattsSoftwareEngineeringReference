#include <iostream>
#include<tuple>

/**
 * Created by Matthieu J. Capuano on 12/06/2021.
 */
class Constructors {
public:
    int someInt1;
    int someInt2 = 2;
    int someInt3;

    Constructors() {
    }

    Constructors(int someInt1) {
        this->someInt1 = someInt1;
    }

    Constructors(int someInt1, int someInt2) {
        this->someInt1 = someInt1;
        this->someInt2 = someInt2;
    }

    // You need an instance of Constructors to call this function, unlike static functions
    void someFunction() {
        std::cout << "Called someFunction() from: " << this << std::endl;
    }

    // Note: This isn't necessarily called from an instance, so can't print "this"
    static void someStaticFunction() {
        std::cout << "Called someStaticFunction()" << std::endl;
    }

    void printInts() {
        std::cout << "SomeInt values for: " << this << std::endl;
        std::cout << "someInt1: " << someInt1 << std::endl;
        std::cout << "someInt2: " << someInt2 << std::endl;
        std::cout << "someInt3: " << someInt3 << std::endl;
    }

    // You can call a private function from another private or public one.
    void callSomePrivateFunction() {
        std::cout << "Called callSomePrivateFunction() from: " << this << std::endl;
        this->somePrivateFunction();
    }

    // Note: There is no difference if you make this function static or not
    std::tuple<Constructors, Constructors*> createOtherInstances(int someInt) {
        std::cout << "Called createAnotherInstance() from: " << this << std::endl;

        // NOT SURE IF THE MEMORY HERE IS ALLOCATED ON THE HEAP OR NOT, I THINK NOT
        Constructors localCon1;
        localCon1.printInts();  // I DON'T KNOW WHY ID DOESN'T PRINT 0 FOR someInt1 and someInt3

        // Since I'm using the new keyword, the memory should be allocated on the heap
        Constructors* localCon2 = new Constructors(someInt);
        localCon2->printInts();

        return std::make_tuple(localCon1, localCon2);
    }

private:
    void somePrivateFunction() {
        std::cout << "->Called somePrivateFunction() from: " << this << std::endl;
    }

}; // DON'T FORGET THE ; AT THE END OF CLASS DEFINITION

int main(int argc, char const *argv[]) {
    std::cout << "----- Starting the main function: Constructors (C++) -----" << std::endl;
    // Different ways of creating an instance of the class:
    Constructors con1;
    Constructors con1b(49, 50);
    Constructors* con2 = new Constructors;
    Constructors* con3 = new Constructors();
    Constructors* con4 = new Constructors(1, 69);

    std::cout << "---" << std::endl;
    con1.someFunction();
    con2->someFunction();
    con3->someFunction();

    std::cout << "---" << std::endl;
    Constructors::someStaticFunction();
    Constructors::someStaticFunction();
    Constructors::someStaticFunction();

    std::cout << "---" << std::endl;
    con1.printInts();
    con1b.printInts();
    con2->printInts();
    con3->printInts();
    con4->printInts();

    std::cout << "---" << std::endl;
    // The calls below FAIL, because they are calling a private function
    // con1.somePrivateFunction();
    // con2->somePrivateFunction();
    // con3->somePrivateFunction();

    con1.callSomePrivateFunction();
    con2->callSomePrivateFunction();
    con3->callSomePrivateFunction();

    std::cout << "---" << std::endl;
    std::tuple<Constructors, Constructors*> con5and6 = con1.createOtherInstances(5);
    Constructors con5 = std::get<0>(con5and6);
    Constructors* con6 = std::get<1>(con5and6);
    con5.printInts();
    con6->printInts();

    std::cout << "---" << std::endl;
    Constructors con7 = con1;
    std::cout << con1.someInt2 << std::endl;
    std::cout << con7.someInt2 << std::endl;
    con1.someInt2 = 71;
    std::cout << con1.someInt2 << std::endl;
    std::cout << con7.someInt2 << std::endl;

    std::cout << "---" << std::endl;
    std::cout << sizeof(con1) << std::endl; // 12 bytes because 3intsx4bytes = 12 bytes
    std::cout << sizeof(con2) << std::endl; // 8 bytes because this is a pointer

    return 0;
}
