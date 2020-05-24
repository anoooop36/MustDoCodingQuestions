/*
Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int[] reverseArrayInGroups(int arr[], int n, int k){
        for(int i=0;i<n;i += k){
            int j= i;
            int m = Math.min(n-1,i+k-1);
            while(j<m){
                int temp = arr[j];
                arr[j] = arr[m];
                arr[m] = temp;
                j++;
                m--;
            }
        }
        return arr;
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String strs[] = br.readLine().split(" ");
	        int n = Integer.parseInt(strs[0]);
	        int k = Integer.parseInt(strs[1]);
	        strs = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        arr = reverseArrayInGroups(arr, n, k);
	        for(int i=0;i<n;i++){
	            sb.append(arr[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}