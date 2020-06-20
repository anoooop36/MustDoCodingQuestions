/*
Given two strings str1 and str2, find the length of the smallest string which has both, str1 and str2 as its sub-sequences.
Note: str1 and str2 can have both uppercase and lowercase letters.
https://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /*
        f(x,y,m,n) = 1+f(x,y,m-1,n-1) if x[m-1] == y[n-1] else
                   = max(f(x,y,m-1,n), f(x,y,m,n-1))
        base case: f(x,y,m,0) = f(x,y,0,n) = 0
    */
    static int LCS(String X, String Y, int m, int n){
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else {
                    if(X.charAt(i-1) == Y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
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
	        int m = strs[0].length();
	        int n = strs[1].length();
	        sb.append(m+n -LCS(strs[0], strs[1],m,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}