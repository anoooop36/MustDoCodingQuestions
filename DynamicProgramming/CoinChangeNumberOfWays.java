/*
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        either we can take ith coin or not take at all
        
        f(n,i) = f(n,i-1) + f(n-ci, i)  if ci <= n else
               = f(n,i-1)
               
        base case: f(0,i) = 1
                   f(n,0) = 0
     */
    static int coinChange(int value, int coins[], int m){
        
        int dp[][] = new int[m+1][value+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=value;j++){
                if(j==0){
                    dp[i][j] = 1;
                } else if(i == 0){
                    dp[i][j] = 0;
                } else {
                    if(coins[i-1] <= j){
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][value];
    }
     
    public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int m = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[m];
	        for(int i=0;i<m;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        int n = Integer.parseInt(br.readLine());
	        sb.append(coinChange(n, arr, m)+"\n");
	    }
	    System.out.print(sb);
	 }
}