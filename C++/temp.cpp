#include <iostream>
using namespace std;

// Function prototypes
void helper1();
void helper2();

int* f(int list1[], const int list2[], int size) {
    for (int i = 0; i <size; i++) {
        list1[i] += list2[i];
        // list2[i] += 1;   // Compiler ERROR
    }
    return list1;
}

void editList(int list[]) {
    list[0] = 11;
    list[1] = 12;
    std::fill_n(list + 4, 5, 69);
}

int main() {

    int list[15] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    editList(list);
    for (int i = 0; i < sizeof(list)/sizeof(list[0]); i++) {
        std::cout << list[i] << std::endl;
    }


    string test;
    char testChar[1];
    cout << "Type something: " << endl;
    cin >> test;
    cout << test << "\tSize: ";
    cout << test.size();

    return 0;
}

void helper1() {
    int list1[] = {1, 2, 3, 4};
    int list2[] = {1, 2, 3, 4};
    int* p = f(list1, list2, 4);
    cout << p[0] << endl;
    cout << p[1] << endl;

    cout << list1[0] << endl;
    cout << list1[1] << endl;
    cout << list1[2] << endl;
    cout << list1[3] << endl;

    cout << list2[0] << endl;
    cout << list2[1] << endl;
    cout << list2[2] << endl;
    cout << list2[3] << endl;
}

void helper2() {
    int list[] = {3, 4, 2, 5, 6, 1};
    cout << *min_element(list, list + 2) << endl;
    cout << *max_element(list, list + 2) << endl;
    cout << *find(list, list + 6, 2) << endl;
    cout << find(list, list + 6, 20) << endl;
    sort(list, list + 6);
    cout << list[5] << endl;
}
