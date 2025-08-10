import java.util.*;
class Better_Solution{
    public static void merge(int[] arr1, int[] arr2, int m, int n){
        int left = m-1;
        int right = 0;

        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}

public class Better_Approach {
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
