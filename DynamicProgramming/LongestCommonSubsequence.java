/*
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.
https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        LCS(X,Y,m,n) = 1 + LCS(X,Y,m-1,n-1) if x[m-1] == y[n-1] else
                     = Max(LCS(X,Y,m-1,n), LCS(X,Y,m,n-1))
        base case LCS(X,Y,m,0) = 0 and LCS(X,Y,0,n) = 0
     */
    static int LongestCommonSubsequence(String X, String Y, int m, int n){
	
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j == 0){
                    dp[i][j] = 0;
                } else if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[m][n];
    }

     public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String strs[] = br.readLine().split(" ");
	        int m = Integer.parseInt(strs[0]);
	        int n = Integer.parseInt(strs[1]);
	        String X = br.readLine();
	        String Y = br.readLine();
	        sb.append(LongestCommonSubsequence(X,Y,m,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}