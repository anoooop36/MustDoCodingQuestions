/*
Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.
https://practice.geeksforgeeks.org/problems/heap-sort/1#
*/

import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}


// } Driver Code Ends




class Solution
{
    void buildHeap(int arr[], int n)
    {
        for(int i=n/2;i>=0;i--){
            heapify(arr,n,i);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int l = 2*i+1;
        int r = 2*i+2;
        int max = i;
        
        if(l<n && arr[l] > arr[max]) max = l;
        if(r<n && arr[r] > arr[max]) max = r;
        
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }
    
    /*move max element to end of array and decrease size of heap*/
    void extractMax(int arr[], int n){
        if(n>1){
            int max = arr[0];
            arr[0] = arr[n-1];
            arr[n-1] = max; 
            heapify(arr,n-1,0);
        }
    }
    
    public void heapSort(int arr[], int n)
    {
        //build max heap
        buildHeap(arr, n);
        while(n>0){
			//put max element end of array and decrease size of heap
            extractMax(arr,n);
            n--;
        }
    }
 }