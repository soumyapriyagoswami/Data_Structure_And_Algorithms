import java.util.*;

public class average {
    /*
     * using array stream for average calculation
     */
    public static double average(int arr[]) {
        return Arrays.stream(arr).average().orElse(0);
    }

    public static void main(String[] args) {
        // Test cases
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {1, 2, 1, 1, 5, 1};

        System.out.println(average(arr1)); 
        System.out.println(average(arr2)); 
    }
}
