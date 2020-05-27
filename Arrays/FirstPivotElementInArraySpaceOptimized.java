/*
Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller 
and all right elements to it are greater than it.
Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
https://practice.geeksforgeeks.org/problems/unsorted-array/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
     // maintain leftMax. for each element if it is greater than or equal to leftMax can be possible pivot. 
     //for possible pivot check all elements on its right until smaller than it found (update leftMax meanwhile) if
     // end reached then possible is actual pivot else start from next of last failed index.
     static int getPivotElement(int arr[], int n){
         
         int leftMax = arr[0];
         
         for(int i=1;i<n-1;i++){
             if(arr[i] >= leftMax){
                 int possiblePivot = arr[i];
                 leftMax = Math.max(leftMax, possiblePivot);
                 while(i<n-1 && possiblePivot <= arr[i+1]){
                     i++;
                     leftMax = Math.max(leftMax, arr[i]);
                 }
                 if(i==n-1){
                     return possiblePivot;
                 }
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
	        String strs[] = br.readLine().split("\\s+");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(getPivotElement(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}