/*
Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements 
are in sorted order, lowest to highest, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        f(i) =  Max(1, Max(1+f(j) )) where j<i and arr[j] < arr[i]
        f(0) = 1
     */
     static int LIS(int arr[], int n){
         
         int dp[] = new int[n];
         dp[0] = 1;
         int max_so_far = Integer.MIN_VALUE;
         
         for(int i=1;i<n;i++){
             int currMax = 1;
             for(int j=0;j<i;j++){
                 if(arr[i]>arr[j]){
                     currMax = Math.max(currMax, 1+dp[j]);
                 }
             }
             dp[i] = currMax;
             max_so_far = Math.max(max_so_far, dp[i]);
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
	        sb.append(LIS(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}