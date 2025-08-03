import java.util.*;
class Solution{
    // use sorting based algorthm
    public static int find_Duplicates(int[] arr){
        if(arr == null || arr.length < 2){
            throw new IllegalArgumentException("Array must have 2 elements");
        }

        int n = arr.length;
        mergeSort(arr, 0, n-1); // for nlogn sorting merge sort is preferred

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }

        throw new IllegalArgumentException("No duplicates found");
    }

    private static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
        
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            // merge the sorted half
            merge(arr, left, right, mid);

        }
    }

    private static void merge(int[] arr, int left, int right, int mid){
        int n1 = mid - left +1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to a temporary array
        for(int i = 0; i < n1; i++){
            L[i] = arr[left+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 +j];
        }


        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;


        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // copy remaining item from left array
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        // copy remaining items from right array
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
public class Bruteforce {
    public static void main(String[] args){
        int[] arr = {3, 1, 3, 4, 2};
        try{
            int duplicate = Solution.find_Duplicates(arr);
            System.out.println("The duplicate number is: "+duplicate);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
