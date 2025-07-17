// Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
import java.util.*;

public class variation_three {

    // normal approach for genarating the pascal's triangle
    public static int nCr(int n, int r){
        int res = 1;
        for(int i = 0; i < r; i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return (int)res;
    }

    public static List<List<Integer>> PascalTriangle(int n){
        List<List<Integer>> ans = new ArrayList<>();

        // store the entire pascal triangle in temp array
        for(int row = 1; row < n; row++){
            List<Integer> temp = new ArrayList<>();
            for(int col = 1; col <= row; col++){
                temp.add(nCr(row-1, col-1));
            }
            ans.add(temp);
        }
        return ans;
    }

    // optiimal approach

    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = PascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        List<List<Integer>> ans_optimal = pascalTriangle(n);
        for (List<Integer> it : ans_optimal) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
