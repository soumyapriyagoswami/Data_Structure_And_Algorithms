import java.util.*;

class Solution {
    public static void merge(int[] arr1, int[] arr2, int n, int m) {
        int[] arr3 = new int[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        // Merge elements from both arrays in sorted order
        while (left < n && right < m) {
            if (arr1[left] < arr2[right]) {
                arr3[index] = arr1[left];
                left++;
            } else {
                arr3[index] = arr2[right];
                right++;
            }
            index++;
        }

        // Copy remaining elements of arr1
        while (left < n) {
            arr3[index++] = arr1[left++];
        }

        // Copy remaining elements of arr2
        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        // Copy back to original arrays
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = arr1.length; // 4
        int m = arr2.length; // 3
        
        Solution.merge(arr1, arr2, n, m);
        
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}