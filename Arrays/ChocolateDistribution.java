/*
Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. 
Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate 
packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     static long getMinimumDifference(long arr[], int n, int m){
         Arrays.sort(arr);
         long min = Long.MAX_VALUE;
         for(int i=0;i<=n-m;i++){
             min = Math.min(min, arr[i+m-1]-arr[i]);
         }
         return min;
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
	        long arr[] = new long[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Long.parseLong(strs[i]);
	        }
	        int m = Integer.parseInt(br.readLine());
	        sb.append(getMinimumDifference(arr,n,m)+"\n");
	    }
	    System.out.print(sb);
	 }
}