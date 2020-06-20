/*
Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such
that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical 
floor in the worst case while using the best strategy.There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
For more description on this problem see wiki page
https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        f(e,f) = Min(1 + max(f(e-1,k-1), f(e,f-k), f(e,f)) where 0< k <=f
        base case:
        f(0,f) = f
        f(e,0) = 0
     */
    static int minNoOfEggDrop(int eggs, int floors){
        int dp[][] = new int[eggs+1][floors+1];
        
        for(int i=0; i<=eggs; i++){
            for(int j=0; j<=floors; j++){
                if(j==0){
                    // no floors
                    dp[i][j] = 0;
                } 
                 else if(i==0|| i==1){
                    // no eggs or one
                    dp[i][j]= j;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    // take min from all possible itermediate floor
                    for(int k=1; k<=j; k++){
                            dp[i][j] = Math.min(1 +Math.max(dp[i-1][k-1], dp[i][j-k]), dp[i][j]);
                    }
                }
            }
        }
        
        return dp[eggs][floors];
    }
	
	 
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String strs[] = br.readLine().split(" ");
            int eggs = Integer.parseInt(strs[0]);
            int floors = Integer.parseInt(strs[1]);
	        sb.append(minNoOfEggDrop(eggs, floors)+"\n");
	    }
	    System.out.print(sb);
	 }
}