/*
Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right side. 
Also, the rightmost element is always a leader. 
https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     // Scan from right and push higher elements than stack top in stack
     static Stack<Integer> getLeadersInArray(int arr[], int n){
         Stack<Integer> st = new Stack<>();
         st.push(arr[n-1]);
         for(int i=n-2;i>=0;i--){
             if(arr[i] >= st.peek()){
                 st.push(arr[i]);
             }
         }
         return st;
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
	        Stack<Integer> st = getLeadersInArray(arr, n);
	        while(st.size()>0){
	            sb.append(st.peek()+" ");
	            st.pop();
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}