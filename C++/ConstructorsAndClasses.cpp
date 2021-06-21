/**
 * Created by Matthieu J. Capuano on 12/06/2021.
 */

#include <iostream>
#include<tuple>

class ConstructorsAndClasses {
public:
    int someInt1;
    int someInt2 = 2;
    int someInt3;

    ConstructorsAndClasses() {
    }

    ConstructorsAndClasses(int someInt1) {
        this->someInt1 = someInt1;
    }

    ConstructorsAndClasses(int someInt1, int someInt2) {
        this->someInt1 = someInt1;
        this->someInt2 = someInt2;
    }

    // You need an instance of ConstructorsAndClasses to call this function, unlike static functions
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
    std::tuple<ConstructorsAndClasses, ConstructorsAndClasses*> createOtherInstances(int someInt) {
        std::cout << "- Called createOtherInstances() from: " << this << "-" << std::endl;

        // NOT SURE IF THE MEMORY HERE IS ALLOCATED ON THE HEAP OR NOT, I THINK NOT
        ConstructorsAndClasses localCon1;
        localCon1.printInts();  // I DON'T KNOW WHY ID DOESN'T PRINT 0 FOR someInt1 and someInt3

        // Since I'm using the new keyword, the memory should be allocated on the heap
        ConstructorsAndClasses* localCon2 = new ConstructorsAndClasses(someInt);
        localCon2->printInts();

        std::cout << "- Done with call to createOtherInstances()" << std::endl;

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
    ConstructorsAndClasses con1;
    ConstructorsAndClasses con1b(49, 50);
    ConstructorsAndClasses* con2 = new ConstructorsAndClasses;
    ConstructorsAndClasses* con3 = new ConstructorsAndClasses();
    ConstructorsAndClasses* con4 = new ConstructorsAndClasses(1, 69);

    // If you went with first method, can't edit it, if second, you can:
    // con1 = new ConstructorsAndClasses(100, 101); // FAILS, can't reinitialize it as pointer
    con2->someFunction();
    con2 = new ConstructorsAndClasses(100, 101);    // Works just fine
    con2->someFunction();

    // Calling with . vs -> depends on if it's pointer or not
    std::cout << "---" << std::endl;
    con1.someFunction();
    con2->someFunction();
    con3->someFunction();

    // You can call static functions without instances of the class
    std::cout << "---" << std::endl;
    ConstructorsAndClasses::someStaticFunction();
    ConstructorsAndClasses::someStaticFunction();
    ConstructorsAndClasses::someStaticFunction();

    // Just checking that the ints are correct
    std::cout << "---" << std::endl;
    con1.printInts();
    con1b.printInts();
    con2->printInts();
    con3->printInts();
    con4->printInts();

    // You CANNOT call private functions with just an instance of the class
    std::cout << "---" << std::endl;
    // con1.somePrivateFunction();
    // con2->somePrivateFunction();
    // con3->somePrivateFunction();

    // However, you CAN call a public function, that calls the private function
    con1.callSomePrivateFunction();
    con2->callSomePrivateFunction();
    con3->callSomePrivateFunction();

    std::cout << "--- Locally Created and Returned Instances ---" << std::endl;
    std::tuple<ConstructorsAndClasses, ConstructorsAndClasses*> con5and6 = con1.createOtherInstances(5);
    ConstructorsAndClasses con5 = std::get<0>(con5and6);
    ConstructorsAndClasses* con6 = std::get<1>(con5and6);
    con5.printInts();
    con6->printInts();

    //
    std::cout << "---" << std::endl;
    ConstructorsAndClasses con7 = con1;
    std::cout << con1.someInt2 << std::endl;
    std::cout << con7.someInt2 << std::endl;
    con1.someInt2 = 71;
    std::cout << con1.someInt2 << std::endl;
    std::cout << con7.someInt2 << std::endl;

    std::cout << "---" << std::endl;


    std::cout << "---" << std::endl;
    std::cout << sizeof(con1) << std::endl; // 12 bytes because 3intsx4bytes = 12 bytes
    std::cout << sizeof(con2) << std::endl; // 8 bytes because this is a pointer

    return 0;
}
