/*
Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both
subsets is same or not.
https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    /*
        take nth element or leave it
        
        f(sum, n) = f(sum,n-1) || f(sum-arr[n], n-1)  if sum >= arr[n]
        base case: f(0,n) = true and f(sum,0) = sum == 0
    */
    static boolean subsetSum(int sum, int n, int arr[]){
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j] = sum == 0;
                } else if(j==0){
                    dp[i][j] = true;
                } else{
                    if(j>=arr[i-1]){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][sum];
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
	        if(sum%2 == 0 && subsetSum(sum/2,n,arr)){
	            sb.append("YES\n");
	        } else {
	            sb.append("NO\n");
	        }
	    }
	    System.out.print(sb);
	 }
}