/**
 * Created by Matthieu J. Capuano on 17/06/2021.
 */

 // A good article: https://www.cprogramming.com/tutorial/const_correctness.html

#include <iostream>

// Function prototypes:
void constWithPointers();
void constWithReferences1(const int& someInt);
void constWithReferences2(int& someInt);

// class ConstKeyword {
//     void constOnAFunction() const;
// };

int main() {

    constWithPointers();

    // You can pass either a const or non-const to a function that specifies const
    int val1 = 5;
    const int val2 = 5;
    constWithReferences1(val1);
    constWithReferences1(val2);
    // But you CANNOT pass a const var to a function that doesn't specify const
    constWithReferences2(val1);
    // constWithReferences2(val2);


    return 0;
}


void constWithPointers() {
    std::cout << "--- ConstKeyword: Using const on pointers and variables ---" << std::endl;
    const double radius = 5;    // A constant double
    // radius = 6;              // Compiler ERROR, constant double cannot be changed

    // Can also be used to make pointer constant:
    const double* pRadiusNonConst = &radius;    // 1. A non-constant pointer to a constant double
    const double* const pRadiusConst = &radius; // 2. A constant pointer to a constant double
    const double radius2 = 6;       // New constant double (since pointers are for const double)
    pRadiusNonConst = &radius2;     // Non-constant pointer to constant double can be changed
    // pRadiusConst = &radius2;     // Compiler ERROR, Constant pointer cannot be changed

    // What if I the value is not constant and I make the pointer make it constant?
    double circumference = 31.42;   // Non-constant double
    std::cout << circumference << std::endl;    // 31.42
    double* const pCircumference = &circumference;  // 3. A constant pointer to a non-constant double
    *pCircumference = 31;   // circumference can be edited since double is not const
    // pCircumference = &radius2;  // Compiler ERROR, content can be changed but not pointer
    std::cout << circumference << std::endl;    // 31
    const double* const pCircumference2 = &circumference;   // 2. Constant pointer to constant double
    // *pCircumference2 = 32;   // Compiler ERROR, constant double cannot be changed

    // If your variable is not constant, your pointer can but doesn't have to be constant (w.r.t. the variable)
    double area = 78.54;
    double* pArea = &area;          // Works fine
    const double* pArea2 = &area;   // Works fine

    // But if your variable is constant, your pointer needs to be as well (w.r.t the variable)
    const double diameter = 10;
    // double* pDiameter = &diameter;          // Compiler ERROR
    const double* pDiameter2 = &diameter;   // Works fine
}

void constWithReferences1(const int& someInt) {
    std::cout << someInt << std::endl;
}

void constWithReferences2(int& someInt) {
    std::cout << someInt << std::endl;
}


void constWithReferencesAndFunctions() {
    std::cout << "--- ConstKeyword: Using const on References and Functions ---" << std::endl;
    // Basically the same behavior as with pointers I believe;


}
