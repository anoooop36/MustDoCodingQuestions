/*
Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.
https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        f(n) = vn + Max(f(j)) 0<=j<n and vj < vn if no such j then f(n) = vn
     */
     static int maxSumIncreasingSubsequence(int[] values, int n){
         int[] dp = new int[n];
         dp[0] = values[0];
         // handle first one is solution
         int max_so_far = dp[0];
         
         for(int i=1; i<n; i++){
             
			 int leftMax = 0;
             // get max sum from left of current
             for(int j=0;j<i;j++){
                 // should be increasing
                 if(values[j] < values[i]){
                     leftMax = Math.max(leftMax, dp[j]);
                 }
             }
             dp[i] = values[i] + leftMax;
             max_so_far = Math.max(dp[i], max_so_far);
         }
         
         return max_so_far;
     }
    
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(maxSumIncreasingSubsequence(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}