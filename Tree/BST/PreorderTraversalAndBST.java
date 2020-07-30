/*
    Given an array arr of size n, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.
    https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst/0
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int getInorderIndex(int start, int end, int[] pre) {
        for (int i = start + 1; i <= end; i++) {
            if (pre[i] > pre[start])
                return i - 1;
        }
        return end;
    }

    /*
        Solve problem top down if root is in range of min and max recur for subtrees otherwise return false
        Update min max using root. find subtrees using inorder position of root. 
    */
    static boolean isValidPreorder(int start, int end, int min, int max, int[] pre) {
        if (start > end)
            return true;
        if (min < pre[start] && max > pre[start]) {
            int inorderIndex = getInorderIndex(start, end, pre);
            return isValidPreorder(start + 1, inorderIndex, min, pre[start], pre)
                    && isValidPreorder(inorderIndex + 1, end, pre[start], max, pre);
        }
        return false;
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
            if (isValidPreorder(0, n - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, arr))
                sb.append(1 + "\n");
            else
                sb.append(0 + "\n");
        }
        System.out.print(sb);
    }
}