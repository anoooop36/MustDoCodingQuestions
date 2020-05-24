/*
Given an array A of N positive numbers. 
The task is to find the position where equilibrium first occurs in the array. 
Equilibrium position in an array is a position such that the sum of elements
before it is equal to the sum of elements after it.
https://practice.geeksforgeeks.org/problems/equilibrium-point/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int getEquilibriumIndex(int arr[], int n){
        long sum =0;
        for(int i=0;i<n;i++){
            sum+= arr[i];
        }
        
        long leftSum = 0;
        for(int i=0;i<n;i++){
            long rightSum = sum-leftSum-arr[i];
            if(leftSum == rightSum){
                return i+1;
            } else {
                leftSum += arr[i];
            }
        }
        return -1;
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
	        sb.append(getEquilibriumIndex(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}