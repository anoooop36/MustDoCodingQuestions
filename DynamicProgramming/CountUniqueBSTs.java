
/*
    Given an integer N, how many structurally unique binary search trees are there that store values 1...N?
    https://practice.geeksforgeeks.org/problems/unique-bsts/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());

        int dp[] = new int[12];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        /*
         * consider each number as a root node of n numbers. ith number as a root then
         * unique BSTs are = T[i-1]*T[n-i] problem breaks into subproblems use dp
         * 
         * or Use catalan number formula (2n)C(n+1)/n == 2n!/(n+1)!*n!
         */
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }
        System.out.print(sb);
    }
}