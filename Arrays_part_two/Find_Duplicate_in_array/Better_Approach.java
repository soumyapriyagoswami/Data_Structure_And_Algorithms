import java.util.*;
class Solution_better{
    public static int find_duplicate(int[] arr){
        int n = arr.length;
        int[] frequency_Array = new int[n+1];
        for(int i = 0; i < n; i++){
            if(frequency_Array[arr[i]] == 0){
                frequency_Array[arr[i]] += 1;
            }else{
                return arr[i];
            }
        }
        return 0;
    }
}

public class Better_Approach {
    public static void main(String[] args){
        int[] arr = {3, 1, 3, 4, 2};
        try{
            int duplicate = Solution_better.find_duplicate(arr);
            System.out.println("Dulicate number in the array is: "+duplicate);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
