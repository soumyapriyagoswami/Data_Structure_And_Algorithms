import java.util.*;
/*
 * Take another dummy matrix of n*n, and then take the first row of the matrix and put it in the last column of the dummy matrix, 
 * take the second row of the matrix, and put it in the second last column of the matrix and so.
 */
public class Bruteforce {
    public static int[][] rotate_matrix(int[][] matrix){
        int n = matrix.length;
        int[][] new_matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                new_matrix[j][n-i-1] = matrix[i][j];
            }
        }
        return new_matrix;
    }

    public static void main(String[] args){
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotate_matrix(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }
}
