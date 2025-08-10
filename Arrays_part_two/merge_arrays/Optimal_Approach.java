import java.util.*;

class optimal_solution {
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // Case 1: left in arr1, right in arr2
                if (left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right - m);
                }
                // Case 2: both in arr2
                else if (left >= m) {
                    swapIfGreater(arr2, arr2, left - m, right - m);
                }
                // Case 3: both in arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2) {
        if (arr1[index1] > arr2[index2]) {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }
}

public class Optimal_Approach {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int m = arr1.length, n = arr2.length;

        optimal_solution.merge(arr1, arr2, m, n);

        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
