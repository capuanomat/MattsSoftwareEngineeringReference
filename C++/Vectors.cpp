/**
  * NOTES:
  * Why it's bad to do "using namespace std":
  * https://stackoverflow.com/questions/1452721/why-is-using-namespace-std-considered-bad-practice
  * -> Basically if you write the above instead of using std::whateverFunction,
  *    what happens if  you also use another namespace that has a whateverFunction,
  *    then if you just use whateverFunction() in your code, you'll get clashes.
*/
#include <iostream>
#include <string>
#include <vector>

template <typename T>
void printVector(std::vector<T> vec) {
    std::cout << "Vector content: ";
    for (T entry: vec) {
        std::cout << entry << ", ";
    }
    std::cout << std::endl;
}

int main(int argc, char const *argv[]) {
    std::cout << "----- Starting the main function: VECTORS -----" << std::endl;

    // --- You can convert an array to a vector in several different ways ---
    int arr[10];
    std::fill_n(arr, 7, 69);    // Fill arr with 69 up to 7th index
    std::vector<int> arrAsVec1(arr, arr + (sizeof(arr)/sizeof(arr[0])));
    std::vector<int> arrAsVec2(std::begin(arr), std::end(arr));
    std::vector<int> arrAsVec3;
    arrAsVec3.insert(arrAsVec3.begin(), std::begin(arr), std::end(arr));
    std::vector<int> arrAsVec4;
    arrAsVec4.assign(std::begin(arr), std::end(arr));
    // More: https://www.techiedelight.com/convert-array-vector-cpp/
    printVector<int>(arrAsVec1);
    printVector<int>(arrAsVec2);
    printVector<int>(arrAsVec3);
    printVector<int>(arrAsVec4);

    // --- You can directly initialize a vector with a size and all same entries ---
    std::vector<char> stuff(10, 'e');
    printVector<char>(stuff);

    std::cout << "----- Ending the main function: VECTORS -----" << std::endl;
    return 0;
}
