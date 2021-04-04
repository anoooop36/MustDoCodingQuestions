/*
Given an array of 0s and 1s. Find the length of the largest subarray with equal number of 0s and 1s.
https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1#
*/

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}
// } Driver Code Ends




class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int n)
    {
        int resultLength = 0;
        int ones = 0;
        int zeros = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0,-1);
        
        for(int i=0;i<n;i++){
            if(arr[i] == 1)
                ones++;
            else
                zeros++;
            int diff = ones-zeros;
            if(map.containsKey(diff)){
                resultLength = Math.max(resultLength, i-map.get(diff));
            } else {
                map.put(diff,i);
            }
        }
        
        return resultLength;
    }
}