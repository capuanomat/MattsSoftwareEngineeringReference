/**
 * Created by Matthieu J. Capuano on 18/06/2021.
 */

#include <iostream>
#include <typeinfo>

#include "Parent.h"
#include "ChildOne.h"

int main() {
    std::cout << "----- Starting the main function: INHERITANCE -----" << std::endl;

    std::cout << "- Creating parent1 -" << std::endl;
    Parent parent1;
    std::cout << parent1.toString() << std::endl;

    std::cout << "\n- Creating parent2 -" << std::endl;
    Parent parent2("Hello there!", 69);
    std::cout << parent2.toString() << std::endl;

    std::cout << "\n- Creating child1 -" << std::endl;
    ChildOne child1;
    std::cout << child1.toString() << std::endl;

    std::cout << "\n- Creating child2 -" << std::endl;
    ChildOne child2("General Kenobi!", 70);
    std::cout << child2.toString() << std::endl;


    parent1.publicString = "Some public string for parent.";
    child1.publicString = "Some public string for child.";
    std::cout << parent1.toString() << std::endl;
    std::cout << child1.toString() << std::endl;

    parent2.publicString = "Some public string for parent.";
    child2.publicString = "Some public string for child.";
    std::cout << parent2.toString() << std::endl;
    std::cout << child2.toString() << std::endl;

    std::string str = "test";
    std::cout << typeid(str).name() << std::endl;
    std::cout << typeid(parent1).name() << std::endl;
    std::cout << typeid(parent2).name() << std::endl;
    std::cout << typeid(child1).name() << std::endl;
    std::cout << typeid(child2).name() << std::endl;

    return 0;
}
