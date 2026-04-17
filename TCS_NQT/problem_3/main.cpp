#include <iostream>
#include <algorithm> // for swap
using namespace std;

// Utility function to swap blocks
void swapBlocks(int arr[], int fi, int si, int d) {
    for (int i = 0; i < d; i++) {
        int temp = arr[fi + i];
        arr[fi + i] = arr[si + i];
        arr[si + i] = temp;
    }
}

// Block Swap Algorithm for left rotation
void leftRotate(int arr[], int n, int k) {
    if (k == 0 || k == n) return;

    int i = k;     // size of left block
    int j = n - k; // size of right block

    while (i != j) {
        if (i < j) { // left block smaller
            swapBlocks(arr, k - i, k + j - i, i);
            j -= i;
        } else {     // right block smaller
            swapBlocks(arr, k - i, k, j);
            i -= j;
        }
    }
    // finally swap equal blocks
    swapBlocks(arr, k - i, k, i);
}

// Right rotation is just left rotation by (n - k)
void rightRotate(int arr[], int n, int k) {
    leftRotate(arr, n, n - k);
}

// Helper to print array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) cout << arr[i] << " ";
    cout << endl;
}

int main() {
    int arr1[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr1) / sizeof(arr1[0]);
    int k = 2;

    cout << "Original array: ";
    printArray(arr1, n);

    leftRotate(arr1, n, k);
    cout << "Left rotation by " << k << ": ";
    printArray(arr1, n);

    int arr2[] = {1, 2, 3, 4, 5};
    rightRotate(arr2, n, k);
    cout << "Right rotation by " << k << ": ";
    printArray(arr2, n);

    return 0;
}
