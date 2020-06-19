/*
    A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    /*
        f(n) = sum(f(n-jumps[j])) where 0<j<=m && jumps[j] <= n
        base case: f(0) = 1
    */
    static int numberOfHops(int N, int jumps[], int m){
        int dp[] = new int[N+1];
        dp[0] = 1;
        
        for(int i=1;i<=N;i++){
            dp[i] = 0;
            for(int j=0;j<m;j++){
                if(jumps[j] <= i){
                    dp[i] += dp[i-jumps[j]];
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
	        int arr[] = new int[]{1,2,3};
	        sb.append(numberOfHops(n,arr,3)+"\n");
	    }
	    System.out.print(sb);
	 }
}