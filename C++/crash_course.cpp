/*
    File with introductory C++ syntax created from following the tutorial below.
    Tutorial: https://www.youtube.com/watch?v=N5HgK1bTLOg
    Author: Matthieu J. Capuano
*/

// Contains functions for converting between data types, random number generation,
// memory management, searching, math, sorting and other general purpose functions
#include <cstdlib>

// Provides functions for performing input and output operations
#include <iostream>

#include <stdio.h>
#include <cstdlib>
#include <iostream>

// Allows you to use the STL string class
#include <string>

// Provides functions to find min and max values for data types
#include <limits>

// Global variables are declared outside of any functions and can be accessed any where in the code
int g_iRandNum = 0;

// const defines constant values that won't change
const double PI = 3.1415926535897932;

int main() {

    bool bMarried = true;

    // char stores 256 single characters represented by your keyboard
    char chMyGrade = 'A';

    // unsigned short ints hold values from 0 to 65,535
    // unsigned int & unsigned long int double their max value
    unsigned short int u16Age = 43;

    // short ints store between -32,768 to 32,767
    short int siWeight = 180;

    // ints range from -2147483648 to 2147483647
    int nDays = 7;

    // long ints and long long ints range from -9223372036854775808 to 9223372036854775807
    long lBigNum = 1000000;

    // floats range from 1.17549e-38 to 3.40282e+38
    float fPi = 3.14159;

    // Show float precision
    float fBigFloat = 1.1111111111;
    float fBigFloat2 = 1.1111111111;
    float fFloatSum = fBigFloat + fBigFloat2;

    // Allows you to print with formatting
    // Float addition has 6 digits of precision
    printf("fFloatSum Precision : %.10f\n", fFloatSum);

    // doubles range from 2.22507e-308 to 1.79769e+308

    std::cout << "Min double " << std::numeric_limits<double>::min() << "\n";
    std::cout << "Max double " << std::numeric_limits<double>::max() << "\n";

    // We can check the precision kept for a specific data type by trying an addition:
    double dbBigFloat = 1.11111111111111111111;
    double dbBigFloat2 = 1.11111111111111111111;
    double dbFloatSum = dbBigFloat + dbBigFloat2;

    printf("dbFloatSum Precision : %.20f\n", dbFloatSum); // Double addition has 15 digits of precision

    //NOTE: try replacing double above with different data types and notice, for example, that a float has 6 decimal places of precision


    // long doubles range from 3.3621e-4932 to 1.18973e+4932
    long double ldPi = 3.1415926535897932;

    // You can have the compiler assign a type
    // NOTE: THIS PART WILL GIVE YOU AN ERROR UNLESS YOU COMPILE WITH "g++ --std=c++11 filename.cpp"
    auto whatWillIBe = true;

    // SHOW DATA TYPES MIN & MAX VALUES

    std::cout << "Min bool " << std::numeric_limits<bool>::min() << "\n";
    std::cout << "Max bool " << std::numeric_limits<bool>::max() << "\n";

    std::cout << "Min unsigned short int " << std::numeric_limits<unsigned short int>::min() << "\n";
    std::cout << "Max unsigned short int " << std::numeric_limits<unsigned short int >::max() << "\n";

    std::cout << "Min short int " << std::numeric_limits<short int>::min() << "\n";
    std::cout << "Max short int " << std::numeric_limits<short int>::max() << "\n";

    std::cout << "Min int " << std::numeric_limits<int>::min() << "\n";
    std::cout << "Max int " << std::numeric_limits<int>::max() << "\n";

    std::cout << "Min long " << std::numeric_limits<long int>::min() << "\n";
    std::cout << "Max long " << std::numeric_limits<long int>::max() << "\n";

    std::cout << "Min float " << std::numeric_limits<float>::min() << "\n";
    std::cout << "Max float " << std::numeric_limits<float>::max() << "\n";

    std::cout << "Min long double " << std::numeric_limits<long double>::min() << "\n";
    std::cout << "Max long double " << std::numeric_limits<long double>::max() << "\n";

    // To see how many bytes a specific data type uses:
    std::cout << "int Size " << sizeof(int) << "\n";
    std::cout << "double Size " << sizeof(double) << "\n";

    // printf() formatting
    printf("%c %d %5d %.3f %s\n", 'A', 10, 5, 3.1234, "Hi");


    // To convert a string to integer
    std::string example_string = '12'
    int example_int = std:stoi(example_string)


    return 0;
}
