/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total 
value in the knapsack. Note that we have only one quantity of each item. In other words, given two integer arrays 
val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an 
integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights
of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        f(W,n) = Max( f(W,n-1), vn + f(W-wn, n-1)) if wn <= W else
                f(W,n-1)
        base cases:
        f(W,0) = 0
        f(0,n) = 0
     */
     
	 static int zeroOneKnapsack(int W, int n, int values[], int weights[]){
	     
	     int dp[][] = new int[n+1][W+1];
	     
	     for(int i=0; i<=n; i++){
	         for(int j=0; j<=W; j++){
	             if(i==0 || j==0){
	                 dp[i][j] = 0;
	             } else if(weights[i-1] > j){
	                 dp[i][j] = dp[i-1][j];
	             } else {
	                 dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
	             }
	         }
	     }
	     
	     return dp[n][W];
	 }
	 
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        int W = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int values[] = new int[n];
	        for(int i=0;i<n;i++){
	            values[i] = Integer.parseInt(strs[i]);
	        }
	        strs = br.readLine().split(" ");
	        int weights[] = new int[n];
	        for(int i=0;i<n;i++){
	            weights[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(zeroOneKnapsack(W, n, values, weights)+"\n");
	    }
	    System.out.print(sb);
	 }
}