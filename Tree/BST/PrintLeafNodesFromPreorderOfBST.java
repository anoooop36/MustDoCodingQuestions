/*
Given a preorder traversal of a BST, print the leaf nodes of the tree without building the tree.
https://practice.geeksforgeeks.org/problems/print-leaf-nodes-from-preorder-traversal-of-bst/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    /*
        Use queue and min max to traverse tree. Consider first element as root of queue.
        If after traversing left and right subtree size of queue doesnt change then its a leaf node
    */
    static void preorderToPostorder(Queue<Integer> q, ArrayList<Integer> res, int min, int max) {
        if (q.size() == 0)
            return;
        if (q.peek() > min && q.peek() < max) {
            int val = q.poll();
            int size = q.size();
            preorderToPostorder(q, res, min, val);
            preorderToPostorder(q, res, val, max);
            // no change in size , its a leaf node
            if (q.size() == size)
                res.add(val);
        }
    }

    public static void main(String[] args) throws IOException {
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
            ArrayList<Integer> res = new ArrayList<Integer>();
            preorderToPostorder(queue, res, Integer.MIN_VALUE, Integer.MAX_VALUE);
            Collections.sort(res);
            for (int num : res) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}