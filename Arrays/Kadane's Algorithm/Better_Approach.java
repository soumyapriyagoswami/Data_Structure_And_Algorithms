import java.util.*;

public class Better_Approach {
    public static int maximum_subarray(int[] arr, int n){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n ; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                // current subarray = arr[i.....j]

                //add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }



    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maximum_subarray(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
