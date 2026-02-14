import java.util.*;
public class main{

    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("\nProcessing steps:");
        System.out.println("Step | Current | UniquePos | Array State");
        System.out.println("-".repeat(60));

        int uniquePos = 0;
        System.out.printf("%4d | %7s | %9d | %s%n", 
            0, "-", uniquePos, arrayToString(nums, uniquePos));

        for(int current = 1; current < nums.length; current++){
            if(nums[current] != nums[uniquePos]){
                uniquePos++;
                nums[uniquePos] = nums[current];
                System.out.printf("%4d | %7d | %9d | %s%n", 
                    current, nums[current], uniquePos, arrayToString(nums, uniquePos));
            }else{
                System.out.printf("%4d | %7d | %9d | %s (duplicate, skipped)%n", 
                    current, nums[current], uniquePos, arrayToString(nums, uniquePos));
            }
        }

        int newLength = uniquePos + 1;
        System.out.println("\nFinal array (first " + newLength + " elements are unique):");
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, newLength)));

        return newLength;
    }

    private static String arrayToString(int[] nums, int uniquePos){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < nums.length; i++){
            if(i == uniquePos){
                sb.append("*").append(nums[i]).append("*");
            }else{
                sb.append(nums[i]);
            }
            if(i < nums.length-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }
    public static void main(String[] args) {
        // Test Case 1: Basic duplicates
        System.out.println("TEST CASE 1: [1,1,2]");
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.println("Number of unique elements: " + k1);
        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, k1)));
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test Case 2: Multiple duplicates
        System.out.println("TEST CASE 2: [0,0,1,1,1,2,2,3,3,4]");
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        System.out.println("Number of unique elements: " + k2);
        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, k2)));
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test Case 3: All unique
        System.out.println("TEST CASE 3: [1,2,3,4,5]");
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = removeDuplicates(nums3);
        System.out.println("Number of unique elements: " + k3);
        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, k3)));
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test Case 4: All same
        System.out.println("TEST CASE 4: [1,1,1,1,1]");
        int[] nums4 = {1, 1, 1, 1, 1};
        int k4 = removeDuplicates(nums4);
        System.out.println("Number of unique elements: " + k4);
        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, k4)));
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test Case 5: Empty array
        System.out.println("TEST CASE 5: []");
        int[] nums5 = {};
        int k5 = removeDuplicates(nums5);
        System.out.println("Number of unique elements: " + k5);
    }
}