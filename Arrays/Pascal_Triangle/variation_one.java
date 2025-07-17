// Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
import java.util.*;

public class variation_one {
    public static long nCr (int n, int r){
        int res = 1;

        for(int i = 0; i < r; i++){
            res = res * (n-i);
            res = res/ (i+1);
        }
        return res;
    }

    public static int Pascal_triangle(int row, int col){
        int element = (int) nCr(row-1,col-1);
        return element;
    }

    public static void main(String[] args){
        int r = 5;
        int c = 3; 
        int element = Pascal_triangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }



}
