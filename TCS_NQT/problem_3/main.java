import java.util.*;

public class main {
    // Utility function to swap blocks
    static void swapBlocks(int[] arr, int fi, int si, int d) {
        for (int i = 0; i < d; i++) {
            int temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    // Block swap algorithm for left rotation
    static void leftRotate(int[] arr, int n, int k) {
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
    static void rightRotate(int[] arr, int n, int k) {
        leftRotate(arr, n, n - k);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int n = arr1.length;
        int k = 2;

        System.out.println("Original array: " + Arrays.toString(arr1));

        leftRotate(arr1, n, k);
        System.out.println("Left rotation by " + k + ": " + Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        rightRotate(arr2, n, k);
        System.out.println("Right rotation by " + k + ": " + Arrays.toString(arr2));
    }
}
