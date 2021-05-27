#include <iostream>
#include <string>

template <typename T, size_t n>
void printArray(T const(&arr)[n]) {
    std::cout << "Array content: ";
    for (T entry: arr)
        std::cout << entry << ", ";
    std::cout << std::endl;
}

int main(int argc, char const *argv[]) {
    std::cout << "----- Starting the main function: ARRAYS -----" << std::endl;

    // --- You can fill an array up to the nth index with a specific entry ---
    int arr[10];
    std::fill_n(arr, 5, 69);    // Fill up to 5th index with 69
    printArray<int>(arr);
    std::fill_n(arr, 3, 70);    // Re-fill up to 3rd index with 70
    printArray<int>(arr);
    // If you try to fill beyond array capacity, everything will still execute but you will get Abort trap: 6
    // std::fill_n(arr, 15, 71);
    // printArray<int>(arr);

    std::cout << "----- Ending the main function: ARRAYS -----" << std::endl;
    return 0;
}
