/*
Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the 
denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued 
coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.
https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    static String getMinNoOfCoins(int n, int[] coins, int m){
        
        int dp[] = new int[n+1];
        dp[0] = 0;
        
        // keeps index of coin selected for i value;
        int selectedIndexes[] = new int[n+1];
        
        for(int i=1; i<=n; i++){
            
            int minCoins = Integer.MAX_VALUE;
            
            for(int j=0; j<m; j++){
                
                // current coin has less value than i 
                if(i >= coins[j]){
                    
                    // update min no of coins required when found better solution
                    if(minCoins > dp[i-coins[j]]){
                        
                        minCoins = dp[i-coins[j]];
                        // keep selected coins index for part of i value solution
                        selectedIndexes[i] = j;
                    }
                }
            }
            
            if(minCoins != Integer.MAX_VALUE)
                dp[i] = 1+ minCoins;
            else
                dp[i] = minCoins;
        }
        
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            // keep coins in reverse order
            sb.insert(0, coins[selectedIndexes[n]] + " ");
            // reduce problem
            n -= coins[selectedIndexes[n]];
        }
        return sb.toString();
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    int coins[] = new int[] { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        sb.append(getMinNoOfCoins(n, coins, coins.length)+"\n");
	    }
	    System.out.print(sb);
	 }
}