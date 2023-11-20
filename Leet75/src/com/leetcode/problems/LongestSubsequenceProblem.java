package com.leetcode.problems;

import java.util.Arrays;

public class LongestSubsequenceProblem {

    /**
     * <img src="./doc-files/Longest_Subsequence_DP.png" style="width: 60%;"/>
     * @see <a href="https://www.youtube.com/watch?v=0yvOxPwe3Dg">DP</a>
     */

    public static void main(String... args){
        int m =3 , n = 6;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = -1;
            }

        }
        String a = "ate", b = "abtety";
        int x = lcsUtil(m, n, a, b, dp);
        System.out.println(x);
    }

    private static int lcsUtil(int m, int n, String a, String b,int[][] dp) {

        if(m == 0 || n == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(a.charAt(m-1) == b.charAt(n - 1)){
            return dp[m][n] = 1 + lcsUtil(m-1,n-1, a, b,dp);
        }else{
            return dp[m][n] = Math.max(lcsUtil(m-1,n, a, b,dp) , lcsUtil(m, n-1,a, b,dp));
        }

    }

    private static int lcsUtilBFS(int m, int n, String a, String b,int[][] dp) {

        for (int i = a.length() - 1; i >= 0 ; i--) {
            for (int j = b.length() - 1; j >= 0 ; j--) {
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        return dp[0][0];
    }
}
