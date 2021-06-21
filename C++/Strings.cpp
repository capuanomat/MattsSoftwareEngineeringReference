/**
 * Created by Matthieu J. Capuano on 26/05/2021.
 */

#include <iostream>

int main() {
    std::cout << "----- Starting the main function: STRINGS -----" << std::endl;

    std::string* str1 = new std::string("This is a first test!");
    // std::string str2 = new std::string("This is a secont test!");
    // std::string* str3 = "This is a third test!";
    std::string str4 = "This is a fourth test!";

    std::cout << str1 << std::endl;
    std::cout << *str1 << std::endl;
    std::cout << str4 << std::endl;


    // Convert integer to string
    int num = 10;
    std::string strNum = std::to_string(num);

    return 0;
}
