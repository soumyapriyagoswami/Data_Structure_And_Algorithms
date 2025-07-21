// This problem is a variation of the popular Dutch National flag algorithm. 

/*
 * This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

    arr[0….low-1] contains 0. [Extreme left part]
    arr[low….mid-1] contains 1.
    arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
 */
import java.util.*;

public class Optimal_Approach {
    /*
     * First, we will run a loop that will continue until mid <= high.
There can be three different values of mid pointer i.e. arr[mid]
If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid.
 Now the subarray from index 0 to (low-1) only contains 0.
If arr[mid] == 1, we will just increment the mid pointer and 
then the index (mid-1) will point to 1 as it should according to the rules.
If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. 
Now the subarray from index high+1 to (n-1) only contains 2.
In this step, we will do nothing to the mid-pointer as even after swapping, 
the subarray from mid to high(after decrementing high) might be unsorted.
 So, we will check the value of mid again in the next iteration.
     */
    public static void Sorted_array(ArrayList<Integer> arr, int n){
        int low = 0, mid = 0, high = n-1;

        while(mid <= high){
            if(arr.get(mid) == 0){
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid,temp);

                low++;
                mid++;
            }

            else if(arr.get(mid) == 1){
                mid++;
            }

            else{
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high,temp);

                high--;
            }
        }
        
    }
    public static void main(String[] args){
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        Sorted_array(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
    
}
