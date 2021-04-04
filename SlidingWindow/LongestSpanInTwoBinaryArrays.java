/*
Given two binary arrays arr1[] and arr2[] of same size N. Find length of the longest common span [i, j] where j>=i 
such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j]. 
https://practice.geeksforgeeks.org/problems/longest-span-with-same-sum-in-two-binary-arrays5142/1
*/

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean arr1[] = new boolean[n];
            boolean arr2[] = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1") ? true : false;
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1") ? true : false;
            }

            int ans = new Solution().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int firstSum = 0, secondSum = 0;
        
        map.put(0,-1);
        
        for(int i=0;i<n;i++){
            firstSum += arr1[i]?1:0;
            secondSum += arr2[i]?1:0;
            
            int diff = firstSum - secondSum;
            
            if(map.containsKey(diff)){
                maxLength = Math.max(maxLength, i-map.get(diff));
            } else {
                map.put(diff,i);
            }
        }
        
        return maxLength;
    }
}