/*
Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth 
smallest element in the given array. It is given that all array elements are distinct.
Expected Time Complexity: O(n)
https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     // Create max Heap of size k. For rest of elements add only if heap head is larger (remove head then add).
     // O((n-k)logk)
	 static int kthSmallestUsingMaxHeap(int arr[], int n, int k){
	     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	     for(int i=0;i<k;i++){
	         pq.add(arr[i]);
	     }
	     for(int i=k;i<n;i++){
	         if(pq.peek() > arr[i]){
	             pq.poll();
	             pq.add(arr[i]);
	         }
	     }
	     if(pq.size() == k)
	        return pq.peek();
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
	        int k = Integer.parseInt(br.readLine());
	        sb.append(kthSmallestUsingMaxHeap(arr,n,k)+"\n");
	    }
	    System.out.print(sb);
	 }
}