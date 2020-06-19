/*
Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their 
sums is minimum.
https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        f(sum,i) = f(sum-arr[i-1], i-1) || f(sum,i-1) where sum>= arr[i-1]
        
        base case:
        f(sum,0) = sum==0
        f(0,i) = true;
     */
     static int minSumPartition(int[] arr, int n, int halfSum){
         boolean dp[][] = new boolean[n+1][halfSum+1];
         
         for(int i=0;i<=n;i++){
             for(int j=0;j<=halfSum;j++){
                 if(i==0){
                     dp[i][j] = j==0;
                 } else if(j==0) {
                     dp[i][j] = true;
                 } else{
                     dp[i][j] = dp[i-1][j];
                     if(j>=arr[i-1]){
                         dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i][j] ;
                     }
                 }
             }
         }
         
         //look for nearest to half
         for(int j=halfSum;j>=0;j--){
             if(dp[n][j] == true)
                return j;
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
	        int sum = 0;
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	            sum += arr[i];
	        }
	        int sumSet1 = minSumPartition(arr,n,sum/2);
	        int absDiff = Math.abs((sum-sumSet1)-sumSet1);
	        sb.append(absDiff+"\n");
	    }
	    System.out.print(sb);
	 }
}