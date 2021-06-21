#include <iostream>
#include <string>
using namespace std;

class Person {
public:
    void printInfo() {
        cout << getInfo() << endl;
    }

    virtual string getInfo() {  // Try removing virtual here
        return "Person";
    }
};

class Student: public Person {
public:
  string getInfo() {
      return "Student";
  }
};

int main() {
  Person().printInfo();
  Student().printInfo();
}
