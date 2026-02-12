import java.util.*;
class Solve_Naive{
    // REcurxive function to find the LCS
    static int Lcs_util(String s1, String s2, int ind1, int ind2, int[][] dp){
        // if either of the string reaches end return 0
        if(ind1 < 0 || ind2 < 0) return 0;
         // If the result for this subproblem has already been calculated, return it
         if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
         // If the characters at the current indices are the same, increment the LCS length
         if(s1.charAt(ind1) == s2.charAt(ind2)) return dp[ind1][ind2] = 1 + Lcs_util(s1, s2, ind1-1, ind2-1, dp);
         else return dp[ind1][ind2] = Math.max(Lcs_util(s1, s2, ind1-1, ind2, dp), Lcs_util(s1, s2, ind1, ind2-1, dp));
    }

    static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        // create 2D array to store the results
        int dp[][] = new int[n][m];

        // initialize the dp array with -1 to indicate the subproblems that are not solved yet
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return Lcs_util(s1, s2, n-1, m-1, dp);
    }
}
class Naive_solution{
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + Solve_Naive.lcs(s1, s2));
    }
}