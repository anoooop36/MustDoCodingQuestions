/*
You are given an array A, of N elements. Find minimum index based distance between two elements of the array, x and y.
https://practice.geeksforgeeks.org/problems/minimum-distance-between-two-numbers/1
*/

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}



class Solution {

    /*
    	x y or y x will be pairs that we need to consider
	iterate through each element of array if it is x match it with previous y or if it is y then match it with previous x
	and update min distance. O(N)
    */
    int minDist(int arr[], int n, int x, int y) {
       int prev = -1;
       int min = Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
           if(arr[i] == x || arr[i] == y){
               if(prev != -1){
                   if((arr[prev] == x && arr[i] == y  || arr[prev] == y && arr[i] == x )){
                       min = Math.min(min, i-prev);
                   }
               }
               prev = i;
           }
       }
       if(min<n){
            return min;
       } else{
           return -1;
       }
    }
}
