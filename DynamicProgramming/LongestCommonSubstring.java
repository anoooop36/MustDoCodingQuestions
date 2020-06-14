/*
Given two strings X and Y. The task is to find the length of the longest common substring.
https://practice.geeksforgeeks.org/problems/longest-common-substring/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
     /*
        LCS(i,j,X,Y,m,n) = 0 if i==0 || j==0 || X[i-1] != Y[j-1]  else
                         = 1 + LCS(i-1,j-1,X,Y,m,n)
     */
     static int LongestCommonSubstring(String x, String y, int m, int n){
         
         int max = Integer.MIN_VALUE;
         int dp[][] = new int[m+1][n+1];
         
         for(int i=0;i<=m;i++){
             for(int j=0;j<=n;j++){
                 if(i==0 || j == 0 || x.charAt(i-1) != y.charAt(j-1)){
                     dp[i][j] = 0;
                 } else {
                     dp[i][j] = 1 + dp[i-1][j-1]; 
                 }
                 max = Math.max(max, dp[i][j]);
             }
         }
         return max;
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
	        sb.append(LongestCommonSubstring(X,Y,m,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}