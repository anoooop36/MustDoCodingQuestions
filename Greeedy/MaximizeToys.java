/*
Given an array consisting cost of toys. Given an integer K depicting the amount with you. Maximise the number of toys you can have with K amount.
https://practice.geeksforgeeks.org/problems/maximize-toys/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static int getMaxToys(Integer costs[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(costs));
        int count = 0;
        while (k > 0 && pq.size() > 0) {
            if (pq.peek() <= k) {
                count++;
                k -= pq.peek();
            }
            pq.poll();
        }
        return count;
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

            Integer arr[] = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs2[i]);
            }

            sb.append(getMaxToys(arr, n, k) + "\n");
        }
        System.out.print(sb);
    }
}