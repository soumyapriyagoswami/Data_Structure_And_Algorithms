import java.util.*;

class Solve_Tabulur {
    static int Lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // create a 2D array DP
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the first row and column with zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                // If the characters are different, choose the maximum LCS length by either
                // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
    }
}

class Tabular_method {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + Solve_Tabulur.Lcs(s1, s2));
    }
}