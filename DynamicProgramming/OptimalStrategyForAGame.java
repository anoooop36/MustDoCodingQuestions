/*
You are given an array A of size N. The array contains integers and is of even length. The elements of the array 
represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.
In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and
receives the value of the coin.You need to determine the maximum possible amouint of money you can win if you go first.
https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /*
        f(i,j) = max(arr[i]+min(f(i+1,j-1), f(i+2,j-1)), arr[j]+min(f(i+1,j-1), f(i,j-2)))
        
        base case: 
        f(i,i) = arr[i]
        f(i,i+1) = max(arr[i], arr[j])
    */
    static int OptimalStrategyForGame(int arr[] ,int n){
        int dp[][] = new int[n][n];
        
        for(int length = 1; length<=n; length++){
            for(int i=0;i<=n-length;i++){
                int j = i+length-1;
                if(length == 1 ){
                    dp[i][j] = arr[i];
                } else if(length == 2){
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    dp[i][j] = Math.max(arr[i]+Math.min(dp[i+1][j-1], dp[i+2][j]), 
                                        arr[j]+Math.min(dp[i+1][j-1], dp[i][j-2]));
                }
            }
        }
        
        return dp[0][n-1];
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
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        sb.append(OptimalStrategyForGame(arr,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}