/**
 * Created by Matthieu J. Capuano on 18/06/2021.
 */

 #include <iostream>

 class Person {
 public:
     Person() {
         std::cout << "Person() constructor called." << std::endl;
     }

     ~Person() {
         std::cout << "Person() destructor called." << std::endl;
     }
 };

class Employee : public Person {
public:
    Employee() {
        std::cout << "Employee() constructor called." << std::endl;
    }

    ~Employee() {
        std::cout << "Employee() destructor called." << std::endl;
    }
};

class Faculty : public Employee {
public:
    Faculty() {
        std::cout << "Faculty() constructor called." << std::endl;
    }

    ~Faculty() {
        std::cout << "Faculty() destructor called." << std::endl;
    }
};

int main() {
    Faculty faculty;
    return 0;
}
