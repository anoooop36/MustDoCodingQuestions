/*
Given an unsorted array A of size N that contains only non-negative integers,
find a continuous sub-array which adds to a given number S.
https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}




class Solution{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int leftSum = 0;
        int i = 0;
        int j=0;
        
        while(j<n){
            leftSum += arr[j];
            
            while(i<=j && leftSum > s){
                leftSum -= arr[i++];
            }
            
            if(leftSum == s){
                result.add(i+1);
                result.add(j+1);
                return result;
            }
            j++;
        }
        
        
        result.add(-1);
        return result;
    }
} 