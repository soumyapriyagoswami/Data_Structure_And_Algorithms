import java.util.*;

public class Optimal_Approach {
    public static int maxProfit(int[] arr){
        int maxprofit = 0;
        int min_price = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            min_price = Math.min(min_price,arr[i]);
            maxprofit = Math.max(maxprofit,arr[i]-min_price);
        }
        return maxprofit;
    }

    public static void main(String[] args){
        int arr[] = {7,1,5,3,6,4};

    int maxPro = maxProfit(arr);
    System.out.println("Max profit is: " + maxPro);
    }
}
