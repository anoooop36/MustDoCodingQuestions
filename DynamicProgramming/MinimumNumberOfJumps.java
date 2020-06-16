/*
Given an array of integers where each element represents the max number of steps that can be made forward from 
that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the
first element). If an element is 0, then cannot move through that element.
https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        f(n) = Min(INF, Min(1+f(j))) where 0<=j<n and j+arr[j] >= n
     */
	 static int minNumberOfJumps(int[] arr, int n){
	 
	     int dp[] = new int[n];
	     dp[0] = 0;
	     
	     for(int i=1; i<n; i++){
	         
	         int currMin = Integer.MAX_VALUE;
	         
	         for(int j=0; j<i; j++){
	             
	             // Must avoid reaching from unreachable
	             if(j+arr[j] >= i && dp[j] != Integer.MAX_VALUE){
				 
	                 currMin = Math.min(currMin, 1 + dp[j] );
	             }
	             
	         }
	         dp[i] = currMin;
	     }
	     
	     return dp[n-1] != Integer.MAX_VALUE ? dp[n-1]: -1;
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
	        sb.append(minNumberOfJumps(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}