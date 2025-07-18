import java.util.*;

public class Optimal_approach {
    public static List< Integer > nextGreaterPermutation(List< Integer > array) {
        int n = array.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (array.get(i) < array.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(array);
            return array;
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (array.get(i) > array.get(ind)) {
                int tmp = array.get(i);
                array.set(i, array.get(ind));
                array.set(ind, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = array.subList(ind + 1, n);
        Collections.reverse(sublist);

        return array;
    }

    public static void main(String args[]) {
        List<Integer> array = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutation(array);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }

}