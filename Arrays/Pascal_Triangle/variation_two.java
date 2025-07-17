// Given the row number n. Print the n-th row of Pascal’s triangle.
import java.util.*;

public class variation_two {
    // normal approach using combination formula
    public static long nCr(int n, int r){
        int res = 1;
        for(int i = 0; i < r; i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return res;
    }

    public static void Pascal_Triangle_naive(int n){
        for(int c = 1; c <= n; c++){
            System.out.print(nCr(n-1,c-1)+ " ");
        }
        System.out.println();
    }


    // Optimal approah

    static void pascalTriangle(int n){
        long ans = 1;
        System.out.print(ans+ " "); // printing the first element

        for(int i = 1; i < n; i++){
            ans = ans * (n-i);
            ans =  ans /i;
            System.out.print(ans+" ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int n = 5;
        Pascal_Triangle_naive(n);
        pascalTriangle(n);
    }
}
