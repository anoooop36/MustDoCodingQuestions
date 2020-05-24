/*
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the
width of each block is 1. Compute how much water can be trapped in between blocks after raining.
https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     // for each element trapped water depends on left max column and right max column of it
     // process elements from both ends using two indexes i=0,j=n-1
     // maintain leftMax and right from both end. process element with low value first and update leftmax
     // rightMax accordingly.
	 static int getTrappedWater(int arr[], int n){
	     int leftMax = arr[0];
	     int rightMax = arr[n-1];

         int i = 0;
         int j = n-1;
         int trappedWater = 0;
         
         while(i <= j){
             if(arr[i] < arr[j]){
                 trappedWater += (Math.min(leftMax,rightMax) - arr[i++]);
                 if(i<n)
                    leftMax = Math.max(leftMax, arr[i]);
             } else {
                 trappedWater += (Math.min(leftMax,rightMax) -arr[j--]);
                 if(j>=0)
                    rightMax = Math.max(rightMax, arr[j]);
             }
         }
	     
	     return trappedWater;
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
	        sb.append(getTrappedWater(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}