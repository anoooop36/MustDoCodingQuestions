/*
Given an array of positive integers. The task is to find inversion count of array.
Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
https://practice.geeksforgeeks.org/problems/inversion-of-array/0/
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
     //Use merge sort get inversion as it requires less number of comparisons and can be done in O(nlogn)
     static long merge(int arr1[], int arr2[], int arr[], int start1, int end1, int start2, int end2, int p){
         long inversion = 0;
         while(start1<=end1 && start2<=end2){
             if(arr1[start1]<=arr2[start2]){
                 arr[p++] = arr1[start1++];
             } else {
                 inversion += (end1-start1+1);
                 arr[p++] = arr2[start2++];
             }
         }
         while(start1<=end1){
             arr[p++] = arr1[start1++];
         }
         while(start2<=end2){
             arr[p++] = arr2[start2++];
         }
         return inversion;
     }
     
     static long partition(int arr[], int i, int j){
         if(i<j){
             int mid = (i+j)/2;
             long inversionLeft = partition(arr, i, mid);
             long inversionRight = partition(arr, mid+1, j);
             int arr1[] = new int[mid-i+1];
             int arr2[] = new int[j-mid];
             for(int k=i;k<=mid;k++){
                 arr1[k-i] = arr[k];
             }
             for(int k=mid+1;k<=j;k++){
                 arr2[k-mid-1] = arr[k];
             }
             
             long inversionMerge = merge(arr1,arr2, arr, 0,mid-i,0,j-mid-1,i);
             return inversionLeft + inversionRight + inversionMerge;
         }
         return 0;
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
	        sb.append(partition(arr,0,n-1)+"\n");
	    }
	    System.out.print(sb);
	 }
}