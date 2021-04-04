/*
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1#
*/

import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<k;i++){
             // add current element to map
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        
        result.add(map.size());
        
        for(int i=k;i<n;i++){
            
            // add current element to map
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            
            Integer count = map.get(A[i-k]);
            
            // remove element outside of window
            if(count == 1){
                map.remove(A[i-k]);
            } else {
                map.put(A[i-k],count-1);
            }
             result.add(map.size());
        }
        
        return result;
    }
}