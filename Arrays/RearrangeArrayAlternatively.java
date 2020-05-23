/*
Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively
i.e first element should be max value, second should be min value, third should be second max, 
fourth should be second min and so on
https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
     // keep both current element and replacing element at same index by using
     // max*replacingElement+ currentElement
     // arr[i]% max always gives old value at index i
     static long[] rearrangeArrayAlternatively(long arr[], int n){
         int maxIndex = n-1;
         int minIndex = 0;
         long max = arr[n-1]+1;
         
         for(int i=0;i<n;i++){
             if(i%2==0){
                 arr[i] += (arr[maxIndex--]%max*max);
             } else {
                 arr[i] += (arr[minIndex++]%max*max);
             }
         }
         
         for(int i=0;i<n;i++){
             arr[i] /= max;
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
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        long arr[] = new long[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Long.parseLong(strs[i]);
	        }
	        arr = rearrangeArrayAlternatively(arr,n);
	        for(int i=0;i<n;i++){
	            sb.append(arr[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}