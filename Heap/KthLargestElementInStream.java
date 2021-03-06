/*
Given an input stream arr[] of n integers, find the kth largest element for each element in the stream.
https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1
*/
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int[] arr = new int[n];
            
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.kthLargest(k,arr,n);
            for(int i=0; i<n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}


class Solution {
    /*
        idea is to maintain min heap of k max elements
    */
    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res[] = new int[n];
        
        // k-1 elements have undefined kth largest
        for(int i=0;i<k-1 && i<n;i++){
            res[i] = -1;
            pq.add(arr[i]);
        }
        
        //kth
        if(k-1<n){
            pq.add(arr[k-1]);
            res[k-1] = pq.peek();
        }
        
        //k+1th
        for(int i=k;i<n;i++){
            if(pq.peek() < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
            res[i] = pq.peek();
        }
        
        return res;
    }
};