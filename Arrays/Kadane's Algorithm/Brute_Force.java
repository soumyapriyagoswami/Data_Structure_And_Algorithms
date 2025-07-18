import java.util.*;

public class Brute_Force {
    public static int maximum_SubArray(int[] array, int n){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n;j++){
                int sum = 0;

                for(int k = i; k <= j; k++){
                    sum += array[k];
                }
                max = Math.max(max,sum);
            }
        }

        return max;
    }


    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maximum_SubArray(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
