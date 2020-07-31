/*
    Given an array arr of size n, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.
    https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst/0
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    /*
        Solve problem top down. Maintain min and max. Have a reference Index starts from 0 . 
        if root is in range of min and max recur for subtrees otherwise return.
        Update min max using root.Update refIndex.
        consider element at ref index as root and check it lies between min max range.
        if all elements processed then its a valid preorder of BST.
    */
    static void isValidPreorder(Start start, int end, int min, int max, int[] pre) {
        if (start.val > end)
            return;
        if (min < pre[start.val] && max > pre[start.val]) {
            int curr = pre[start.val++];
            isValidPreorder(start, end, min, curr, pre);
            isValidPreorder(start, end, curr, max, pre);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strs[] = br.readLine().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            Start start = new Start();
            isValidPreorder(start, n - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, arr);
            if (start.val == n)
                sb.append(1 + "\n");
            else
                sb.append(0 + "\n");
        }
        System.out.print(sb);
    }
}