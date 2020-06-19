/*
Given an integer N denoting the Length of a line segment. you need to cut the line segment in such a way that 
the cut length of a line segment each time is integer either x , y or z. and after performing all cutting 
operation the total number of cutted segments must be maximum. 
https://practice.geeksforgeeks.org/problems/cutted-segments/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        initialize f(i) = Integer.MAX_VALUE where 0<i<=N
        
        f(n) = Max(f(n), 1+f(N-seqments[j])) where 0<=j<m &&  N >= seqments[j] else
            = Integer.MAX_VALUE
        
        base case: f(0) = 0
     */
    static int maxNoOfCutSegments(int N, int[] segs, int m){
        int dp[] = new int[N+1];
        dp[0] = 0;
        
        for(int i=1;i<=N;i++){
            dp[i] = Integer.MIN_VALUE;
            for(int j=0; j<m; j++){
                if(segs[j] <= i && dp[i-segs[j]] != Integer.MIN_VALUE){
                    dp[i] = Math.max(dp[i], 1+dp[i-segs[j]]);
                }
            }
        }
        
        return dp[N];
    }
	 
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine().strip());
	        String strs[] = br.readLine().split("\\s+");
	        int arr[] = new int[3];
	        for(int i=0;i<3;i++){
	            arr[i] = Integer.parseInt(strs[i].strip());
	        }
	        sb.append(maxNoOfCutSegments(n,arr,3)+"\n");
	    }
	    System.out.print(sb);
	 }
}