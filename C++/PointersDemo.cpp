// I recommend reading this file along with my notes from Chapter 11 of
// "Introdution to Programming with C++ (2014) - Daniel Liang"

#include <iostream>
using namespace std;

// Function prototypes
void PointersBasics();
void DereferencingAPointer();
void TwoPointersToTheSameValue();
void CreatingAndAccessingDynamicObjects();

int main() {

    PointersBasics();

    DereferencingAPointer();

    TwoPointersToTheSameValue();

    CreatingAndAccessingDynamicObjects();

    return 0;
}

void PointersBasics() {
    cout << "----- Basics: A Value and its Pointer -----" << endl;
    int count = 5;
    int* pCount = &count;

    cout << "The value of count is " << count << endl;
    cout << "The address of count is " << &count << endl;
    cout << "The address of count is " << pCount << endl;
    cout << "The value of count is " << *pCount << endl;
}

void DereferencingAPointer() {
    cout << endl << "----- Dereferencing a Pointer & Assigning Result makes a Copy -----" << endl;
    int test = 9;
    int* pTest = &test;
    int copy = *pTest; // Dereferencing automatically makes a copy
    copy++;
    cout << "The value of test is " << test << endl;    // 9
    cout << "The value of pTest is " << pTest << endl;  // Some memory address
    cout << "The value of copy is " << copy << endl;    // 10

    (*pTest) += 6;      // De-reference pTest to increment test, should be 15 now
    int* pCopy = &copy; // Make new pointer to copy, which is 10
    cout << "The value of test is " << test << endl;    // 15, just updated
    cout << "The value of copy is " << copy << endl;    // 10, untouched
    cout << "The value of pCopy is " << pCopy << endl;  // Some memory address

    *pCopy = *pTest;    // Assign to copy the value of test, which is 15
    cout << "The value of copy is " << copy << endl;    // 15, same value as test
    cout << "The value of copy is " << *pCopy << endl;  // 15, same value as test
    cout << "The value of test is " << *pTest << endl;  // 15, untouched

    *pTest = 1; // Update test value to o1, copy value is untouched
    cout << "The value of copy is " << *pCopy << endl;  // 15, untouched
    cout << "The value of test is " << *pTest << endl;  // 1, just re-assigned
}

void TwoPointersToTheSameValue() {
    cout << endl << "----- Two Pointers to The Same Value -----" << endl;
    int val = 69;
    int* pVal1 = &val;
    int* pVal2 = &val;
    cout << "The value of pVal1 is " << pVal1 << endl;  // Some memory address
    cout << "The value of pVal2 is " << pVal2 << endl;  // Same address as above
    cout << "The value of val is " << *pVal1 << endl;   // 69
    cout << "The value of val is " << *pVal2 << endl;   // 69

    int** ppVal1 = &pVal1;
    int** ppVal2 = &pVal2;
    cout << "The value of ppVal1 is " << ppVal1 << endl;    // Some mem. address
    cout << "The value of ppVal2 is " << ppVal2 << endl;    // Different address

    *pVal1 = 70;
    cout << "The value of val is " << val << endl;      // 70
    cout << "The value of val is " << *pVal1 << endl;   // 70
    cout << "The value of val is " << *pVal2 << endl;   // 70

    *pVal2 = 71;
    cout << "The value of val is " << val << endl;      // 70
    cout << "The value of val is " << *pVal1 << endl;   // 71
    cout << "The value of val is " << *pVal2 << endl;   // 71
}

void CreatingAndAccessingDynamicObjects() {
    cout << endl << "----- The . and -> Operators -----" << endl;
    string* p = new string("abcdefg");
    std::cout << p << std::endl;    // Some memory address, p is a pointer
    std::cout << *p << std::endl;   // The actual string
    std::cout << "The first three characters in the string are: " << (*p).substr(0, 3) << std::endl;
    std::cout << "The length of the string is: " << (*p).length() << std::endl;

    std::cout << "The first three characters in the string are: " << p->substr(0, 3) << std::endl;
    std::cout << "The length of the string is: " << p->length() << std::endl;

}
