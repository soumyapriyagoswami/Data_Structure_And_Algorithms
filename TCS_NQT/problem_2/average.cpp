#include <iostream>
#include <numeric> 
using namespace std;
template <size_t N>

double average(const int (&arr)[N]) {
    return accumulate(*&arr, *&arr + N, 0.0) / N; 
}


int main() {
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {1, 2, 1, 1, 5, 1};

    cout << "Average of arr1: " << average(arr1) << endl;
    cout << "Average of arr2: " << average(arr2) << endl;

    return 0;
}
