// In C++ many fundamental facilities, like input-output are part of the *standard library* instead of the core language.
// You must explicitly ask for the parts of the standard library you want. This is a *standard header*:
#include <iostream>

int main() {
  // *** PRINTING *** //
  // << is the *output operator*
  std::cout << "Hello world!" << std::endl;
  // Preceding a namy by std:: indicates that the name is part of a *namespace* named std. 
  // A namespace is a collection of related names; the standard library uses
  // "std" to contain all the names that it defines.
  // E.g. the iostream standard header defines the names cout and endl, we refer
  // to these names as std::cout and std::endl (I assume that there's a
  // namespace called std defined within iostream, so we get that when we import
  // iostream.



  // *** ENDING MAIN FUNCTION *** //
  system("pause");

  // Returning a 0 indicates success, any other value means a problem.
  return 0;
}


// *** IMPORTANT NOTES *** //
// It is bad practice to have "using namespace std;": https://stackoverflow.com/questions/1452721/why-is-using-namespace-std-considered-bad-practice
// You can use "using myType = existingDataType" in the same way that you can
// use "typedef existingDataType myType"



// ***** REFERENCES ***** //
// Virtual Functions: https://www.geeksforgeeks.org/virtual-function-cpp/
// std::move: https://en.cppreference.com/w/cpp/utility/move
