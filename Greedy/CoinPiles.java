/*
There are N piles of coins each containing  Ai (1<=i<=N) coins.  Now, you have to adjust the number of coins in each pile such that for any two pile,
if a be the number of coins in first pile and b is the number of coins in second pile then |a-b|<=K. In order to do that you can remove coins from
different piles to decrease the number of coins in those piles but you cannot increase the number of coins in a pile by adding more coins. Now, given
a value of N and K, along with the sizes of the N different piles you have to tell the minimum number of coins to be removed in order to satisfy the given condition.
Note: You can also remove a pile by removing all the coins of that pile.

https://practice.geeksforgeeks.org/problems/coin-piles/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    /*
        sort piles in ascending order
        since we can't increase coins in a pile. either min pile is intact or removed all
        min(pile[0] + T(1,n), count with min pile intact) 
    */
    public static int getMinCoinsToBeRemoved(int[] piles, int n, int k) {

        Arrays.sort(piles);

        int minSoFar = Integer.MAX_VALUE;
        int prevCount = 0;
        int currCount = 0;

        for (int i = 0; i < n; i++) {
            currCount = prevCount;
            prevCount += piles[i];
            for (int j = n - 1; j > i; j--) {
                if (piles[j] - piles[i] > k) {
                    currCount += (piles[j] - piles[i] - k);
                }
            }
            minSoFar = Math.min(minSoFar, currCount);
        }
        return minSoFar;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            String strs1[] = br.readLine().split(" ");
            String strs2[] = br.readLine().split(" ");
            int n = Integer.parseInt(strs1[0]);
            int k = Integer.parseInt(strs1[1]);

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs2[i]);
            }

            sb.append(getMinCoinsToBeRemoved(arr, n, k) + "\n");
        }
        System.out.print(sb);
    }
}