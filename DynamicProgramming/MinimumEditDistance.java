/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits 
(operations) required to convert ‘str1′ into ‘str2′.
Insert
Remove
Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /*
        f(x,y,m,n) = f(x,y,m-1,n-1)             if x[m-1] == y[n-1] else
                   = 1 + Min(f(x,y,m-1,n-1), f(x,y,m-1,n), f(x,y,m,n-1))
                   = m if n==0 (base case)
                   = n if m==0 (base case)
    */
    static int minEditDistance(String X, String Y, int m, int n){
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j] = i|j;
                } else {
                    if(X.charAt(i-1) == Y.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    } else{
                        dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
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
	        int m = Integer.parseInt(strs[0]);
	        int n = Integer.parseInt(strs[1]);
	        strs = br.readLine().split(" ");
	        sb.append(minEditDistance(strs[0],strs[1],m,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}