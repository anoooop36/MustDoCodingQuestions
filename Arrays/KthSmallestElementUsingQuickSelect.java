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

     static void randomisePivot(int arr[], int l, int r){
         int p = l + (int)(Math.random()*(r-l+1));
         int temp = arr[p];
         arr[p] = arr[r];
         arr[r] = temp;
     }
     
     // Based on quick select every call moves towards kth element, O(n2) worst case but expected is O(n)
     static int partition(int arr[], int l, int r, int k){
         if(l<=r && k>=l && k<=r){
             // randomize pivot
             randomisePivot(arr, l, r);
             int pivot = arr[r];
             int j = l;
             for(int i=l;i<=r;i++){
                 if(arr[i] <= pivot){
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                     j++;
                 }
             }
             // pointing next to last swapped so move back
             j--;
             if(j==k)
                return arr[k];
             else if(j > k){
                return partition(arr, l,j-1,k); 
             } else {
                 return partition(arr,j+1,r,k);
             }
         }
         return -1;
     }
     
	 static int kthSmallestUsingQuickSelect(int arr[], int n, int k){
	     return partition(arr,0,n-1,k-1);
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
	        sb.append(kthSmallestUsingQuickSelect(arr,n,k)+"\n");
	    }
	    System.out.print(sb);
	 }
}