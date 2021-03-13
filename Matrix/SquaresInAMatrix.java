/*
Given a mxn matrix, count the number of squares in the matrix.
https://practice.geeksforgeeks.org/problems/squares-in-a-matrix5716/1#
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.squaresInMatrix(m,n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static long squaresInMatrix(int m, int n) {
        /*
        for 1 to min(m,n) sqaure size
	        n*m + n-1*m-1+ n-2*m-2.........
        */
        
        if(n>m){
            int temp = m;
            m = n;
            n = temp;
        }
        
        
        return (n*1L*(n+1)*(3*m-n+1))/6; 
        
        /*
        alternate solution is to get squares in n*n and then add columns (n-m) and for each added coulumn (m*(m+1))/2 more squares
        so solution is n*(n+1)*(2n+1)/6 + (m-n)*(n*(n+1)/2)
        */
    }
};