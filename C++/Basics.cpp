#include <iostream>

// Function prototypes:
void theConstKeyword();
void arraysAsPointers();

int main(int argc, char const *argv[]) {
    std::cout << "----- Starting the main function: BASICS -----" << std::endl;

    // --- The "unsigned" keyword is equivalent to usigned int --- //
    unsigned test = 10;
    std::cout << test << std::endl;

    // --- The "const" Keyword Means the vVriable Cannot be Edited
    theConstKeyword();

    // --- Arrays Are Just Pointers --- //
    arraysAsPointers();

    std::cout << "----- Ending the main function: BASICS -----" << std::endl;
    return 0;
}

void theConstKeyword() {
    std::cout << "--- The 'const' keyword means the variable cannot be edited --- //" << std::endl;
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

    // If your variable is not constant, your pointer can but doesn't have to be constant
    double area = 78.54;
    double* pArea = &area;          // Works fine
    const double* pArea2 = &area;   // Works fine
    // But if your variable is constant, your pointer needs to be as well
    const double diameter = 10;
    // double* pDiameter = &diameter;          // Compiler ERROR
    const double* pDiameter2 = &diameter;   // Works fine
}

void arraysAsPointers() {
    std::cout << "--- Arrays Are Just Pointers ---" << std::endl;
    int list[6] = {11, 12, 13, 14, 15, 16};
    std::cout << "The starting address of the array is " << list << std::endl;
    std::cout << list[4] << std::endl;
    std:: cout << *(list + 5) << std::endl;
    // If you try to access beyond that
    // std::cout << list[6] << std::endl;  // Compiles and runs, but gives a WARNING
    std:: cout << *(list + 6) << std::endl;  // Compiles and runs with NO WARNING! If you read to far out you get SEG FAULT though.
    for (int i = 0; i < (sizeof(list)/sizeof(list[0])); i++) {
        std::cout << "Address: " << (list + i) << " Value: " << list[i] << " Value: " << *(list + i) << std::endl;
    }

    // Try with char array:
    std::cout << "Char array:" << std::endl;
    char list2[5] = {'t', 'h', 'i', 's', 'a'};
    for (int i = 0; i < (sizeof(list2)/sizeof(list2[0])); i++) {
        std::cout << "Address: " << (list2 + i) << " Value: " << list2[i] << " Value: " << *(list2 + i) << std::endl;
    }

    // Try with double array:
    std::cout << "Double array:" << std::endl;
    double list3[5] = {0.0, 0.1, 0.2, 0.3, 0.4};
    for (int i = 0; i < (sizeof(list3)/sizeof(list3[0])); i++) {
        std::cout << "Address: " << (list3 + i) << " Value: " << list3[i] << " Value: " << *(list3 + i) << std::endl;
    }
}
