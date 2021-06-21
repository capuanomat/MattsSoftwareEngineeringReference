/**
 * Created by Matthieu J. Capuano on 26/05/2021.
 */
 
#include <iostream>
#include <string>

// Function prototypes:
void arraysAsPointers();
void printArray(T const(&arr)[n]);

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

    // --- Arrays Are Just Pointers --- //
    arraysAsPointers();

    std::cout << "----- Ending the main function: ARRAYS -----" << std::endl;
    return 0;
}

template <typename T, size_t n>
void printArray(T const(&arr)[n]) {
    std::cout << "Array content: ";
    for (T entry: arr)
        std::cout << entry << ", ";
    std::cout << std::endl;
}

void arraysAsPointers() {
    std::cout << "--- Arrays Are Just Pointers ---" << std::endl;
    int list[6] = {11, 12, 13, 14, 15, 16};
    std::cout << "The starting address of the array is " << list << std::endl;
    std::cout << list[4] << std::endl;
    std:: cout << *(list + 5) << std::endl;
    // If you try to access beyond that
    // std::cout << list[6] << std::endl;  // Compiles and runs, but gives a WARNING
    std:: cout << *(list + 6) << std::endl;  // Compiles and runs with NO WARNING! If you read to far out you get SEG FAULT though.
    for (int i = 0; i < (sizeof(list)/sizeof(list[0])); i++) {
        std::cout << "Address: " << (list + i) << " Value: " << list[i] << " Value: " << *(list + i) << std::endl;
    }

    // Try with char array:
    std::cout << "Char array:" << std::endl;
    char list2[5] = {'t', 'h', 'i', 's', 'a'};
    for (int i = 0; i < (sizeof(list2)/sizeof(list2[0])); i++) {
        std::cout << "Address: " << (list2 + i) << " Value: " << list2[i] << " Value: " << *(list2 + i) << std::endl;
    }

    // Try with double array:
    std::cout << "Double array:" << std::endl;
    double list3[5] = {0.0, 0.1, 0.2, 0.3, 0.4};
    for (int i = 0; i < (sizeof(list3)/sizeof(list3[0])); i++) {
        std::cout << "Address: " << (list3 + i) << " Value: " << list3[i] << " Value: " << *(list3 + i) << std::endl;
    }
}
