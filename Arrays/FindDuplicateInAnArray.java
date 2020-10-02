/*
Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements 
occurring more than once in the given array.

	
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            arr[arr[i]%n] += n;
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]>= 2*n){
                res.add(i);
            }
        }
        
        if(res.size() ==0)
            res.add(-1);
        
        return res;
    }
}
