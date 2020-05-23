/*
Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
Do it in sigle iteration with O(1) space
https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     //use three variables to track 0 and 2 boundary and to stop loop
     // mid is used to stop loop
     static int[] TreeWayPartitionSort(int arr[], int n){
         int low = 0, mid = 0;
         int high = n-1;
         for(int i=0;i<n && mid<=high;i++){
             if(arr[i] == 2){
                 int temp = arr[i];
                 arr[i] = arr[high];
                 arr[high] = temp;
                 high--;
                 i--;
             } else if(arr[i] == 0){
                 int temp = arr[i];
                 arr[i] = arr[low];
                 arr[low] = temp;
                 low++;mid++;
             } else {
                 mid++;
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
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        arr = TreeWayPartitionSort(arr, n);
	        for(int i=0;i<n;i++){
	            sb.append(arr[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}