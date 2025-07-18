import java.util.*;

public class Better_Approach {
    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        // creating row array
        int[] row = new int[n];
        // creaing column array
        int[] column = new int[m];

        // mark 1 in both array
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){ 
                if(matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }


        // now mark 0 in matrix where there is 1 in row and column arrays
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(row[i] == 1 || column[j] == 1){
                    matrix.get(i).set(j,0);
                }
            }
        }
        return matrix;
    }


    public static void main (String[] args){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
