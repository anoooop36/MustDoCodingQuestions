/*
Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.
https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        idea is maintain min heap of k size always while traversal
     */
    static int[] sortNearlySorted(int[]arr, int n, int k){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // first k elements
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        
        
        int[] res = new int[n];
        //get first on kth
        res[0] = pq.poll();
        int j=1;
        
        //k+1th > elements
        for(int i=k;i<n;i++){
            pq.add(arr[i]);
            res[j++] = pq.poll();
        }
        
        while(j<n){
            res[j++] = pq.poll();
        }
        
        return res;
    }
     
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    
	    while(t-- > 0){
	        String[] strs = br.readLine().split(" ");
	        int n = Integer.parseInt(strs[0]);
	        int k = Integer.parseInt(strs[1]);
	        
	        strs = br.readLine().split(" ");
	        int[] arr = new int[n];
	        
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        
	        int[] result = sortNearlySorted(arr,n,k);
	        
	        for(int i=0;i<n;i++){
	            sb.append(result[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}