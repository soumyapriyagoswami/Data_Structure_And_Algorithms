import java.util.*;

// floyd algorithm the optimal approach takes O(n) time with O(1) space, floyd tortoise and hare algorithm
class optimal_solution{
    public static int find_duplicate(int[] arr){
        // initialize the slow and fast pointer to index 0
        int slow = arr[0];
        int fast = arr[0];

        // phase-1: find the intersection
        do{
            slow = arr[slow]; // slow pointer moves 1 steps at a time
            fast = arr[arr[fast]]; // fast pointer moves 2 steps at a time
        }while(slow != fast);

        // find the entrance to cycle
        slow = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}

public class Optimal_Approach {
    public static void main(String[] args){
        int[] arr = {1, 3, 4, 2, 2}; // Example array with duplicate
        int duplicate = optimal_solution.find_duplicate(arr);
        System.out.println("The duplicate value in array is: "+duplicate);
    }
}
