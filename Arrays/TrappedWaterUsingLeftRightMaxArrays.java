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
     // maintain two arrays for left max and right max use it to get trapped water for each column
	 static int getTrappedWater(int arr[], int n){
	     int leftMax[] = new int[n];
	     int rightMax[] = new int[n];
	     
	     leftMax[0] = arr[0];
	     rightMax[n-1] = arr[n-1];
	     
	     for(int i=1;i<n;i++){
	         leftMax[i] = Math.max(leftMax[i-1],arr[i]);
	         rightMax[n-1-i] = Math.max(rightMax[n-i],arr[n-1-i]);
	     }
	     
	     int trappedWater = 0;
	     for(int i=0;i<n;i++){
	         trappedWater += (Math.min(leftMax[i],rightMax[i]) - arr[i]);
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