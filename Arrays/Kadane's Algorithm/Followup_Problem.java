import java.util.*;
public class Followup_Problem {
    public static long max_subArray(int[] arr, int n){
        long max = Long.MIN_VALUE;
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for(int i = 0; i < n; i++){
            if(sum == 0) start = i;
            sum += arr[i];
            if(sum > max){
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0) sum = 0;

        }

        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");

        return max;
    }

    public static void main(String[] args){
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = max_subArray(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
