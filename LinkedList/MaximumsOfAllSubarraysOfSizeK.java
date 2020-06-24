/*
Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    /*
     * solution is to maintain a sliding window and first element always points to
     * maximum element of current window.
     */
    static String maximumsOfAllSubarrays(int arr[], int n, int k) {

        StringBuffer sb = new StringBuffer();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // remove element out of window
            if (list.size() > 0 && i >= list.getFirst() + k) {
                list.removeFirst();
            }

            // remove all smaller elements from last as they will never be part of solution
            while (list.size() > 0 && arr[i] > arr[list.getLast()]) {
                list.removeLast();
            }

            // add element to list
            list.add(i);

            // print only if i has reached window size k
            if (i >= k - 1) {
                sb.append(arr[list.getFirst()] + " ");
            }
        }

        return sb.toString();
    }

    
    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String strs[] = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[1]);
            strs = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            sb.append(maximumsOfAllSubarrays(arr, n, k) + "\n");
        }
        System.out.print(sb);
    }
}