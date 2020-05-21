/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    // two variable solution currMax and maxSoFar as currMax goes below 0 set it to 0
    // it works with all negative elements too
    static long getSubArrayMaxSum(int arr[], int n){
        long max = Integer.MIN_VALUE;
        long currMax = 0;
        for(int i=0;i<n;i++){
            currMax += arr[i];
            if(currMax > max){
                max = currMax;
            }
            if(currMax < 0){
                currMax = 0;
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
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(getSubArrayMaxSum(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}