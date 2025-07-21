import java.util.*;
public class Optimal_approach {
    public static long max_SubArray(int[] arr, int n){
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum > max) max = sum;
            if(sum<0) sum=0;
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = max_SubArray(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
