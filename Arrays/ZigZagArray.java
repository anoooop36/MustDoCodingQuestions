/*
Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. 
The converted array should be in form a < b > c < d > e < f. 
The relative order of elements is same in the output i.e you have to iterate on the original array only.
https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     //catch: At each index we can decide to swap it with next element or not
    public static int[] getZigZagArray(int arr[], int n){
        for(int i=0;i<n-1;i++){
            if(i%2 == 0 && arr[i] > arr[i+1] || i%2 == 1 && arr[i] < arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
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
	        arr = getZigZagArray(arr, n);
	        for(int i=0;i<n;i++){
	            sb.append(arr[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}