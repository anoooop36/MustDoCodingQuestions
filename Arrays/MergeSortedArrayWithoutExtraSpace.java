/*
Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. 
The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    
	// Gets the Nth lagest number form two arrays
    static int getNthLargestNumber(int arr1[], int arr2[], int n, int m){
        int p =0, q = 0;
        for(int i=0;i<n-1;i++){
            if(p<n && q<m){
                if(arr1[p] <= arr2[q]){
                    p++;
                } else {
                    q++;
                }
            } else if(p<n){
                p++;
            } else{
                q++;
            }
        }
        if(p<n && q<m){
            return Math.min(arr1[p],arr2[q]);
        } else if(p<n){
            return arr1[p];
        }
        return arr2[q];
    }
    
    // Keeps larger number than pivot in second array.
    static void swapAroundPivot(int arr1[], int arr2[], int pivot, int n){
        int j=0;
        for(int i=0;i<n;i++){
            if(arr1[i] > pivot){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                j++;
            }
        }
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
	        int m = Integer.parseInt(strs[1]);
	        strs = br.readLine().split(" ");
	        int arr1[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr1[i] = Integer.parseInt(strs[i]);
	        }
	        strs = br.readLine().split(" ");
	        int arr2[] = new int[m];
	        for(int i=0;i<m;i++){
	            arr2[i] = Integer.parseInt(strs[i]);
	        }
	        int nthLagestNumber = getNthLargestNumber(arr1,arr2,n,m);
	        swapAroundPivot(arr1,arr2,nthLagestNumber,n);
	        Arrays.sort(arr1);
	        Arrays.sort(arr2);
	        for(int i=0;i<n;i++){
	            sb.append(arr1[i]+" ");
	        }
	        for(int i=0;i<m;i++){
	            sb.append(arr2[i]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	 }
}