// In C++ many fundamental facilities, line input-output are part of the *standard library* instead of the core language.
// You must explicitly ask for the parts of the standard library you wan. This is a *standard header*:
#include <iostream>

int main() {
	// *** PRINTING *** //
	// << is the *output operator* 
	std::cout << "Hello world!" << std::endl;





	// *** ENDING MAIN FUNCTION *** //
	system("pause");

	// Returning a 0 indicates success, any other value means a problem.
	return 0;
}