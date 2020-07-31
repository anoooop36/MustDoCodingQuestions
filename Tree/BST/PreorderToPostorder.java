/*
Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.
https://practice.geeksforgeeks.org/problems/preorder-to-postorder/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    /*
        start from 0 to n-1 index. Consider each node as root and check it is within range of min max then recurr for its subtrees with updated min max.
    */
    static void preorderToPostorder(Queue<Integer> q, StringBuffer res, int min, int max) {
        if (q.size() == 0)
            return;
        if (q.peek() > min && q.peek() < max) {
            int val = q.poll();
            preorderToPostorder(q, res, min, val);
            preorderToPostorder(q, res, val, max);
            res.append(val + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strs[] = br.readLine().split(" ");
            Integer arr[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(arr));
            StringBuffer res = new StringBuffer();
            preorderToPostorder(queue, res, Integer.MIN_VALUE, Integer.MAX_VALUE);
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}