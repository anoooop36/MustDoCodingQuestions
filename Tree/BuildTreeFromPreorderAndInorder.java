/*
  Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 
*/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for (int i = 0; i < n; i++)
                inorder[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                preorder[i] = sc.nextInt();

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }

    public static void postOrdrer(Node root) {
        if (root == null)
            return;

        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends

class PreIndex {
    int val = 0;
}

class Solution {
    static int getInorderIndex(int in[], int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (in[i] == val)
                return i;
        }
        return -1;
    }

    static Node buildTreeUtil(int in[], int pre[], int startIn, int endIn, PreIndex preIndex) {
        if (startIn > endIn)
            return null;

        int val = pre[preIndex.val];
        Node root = new Node(val);
        int inorderIndex = getInorderIndex(in, startIn, endIn, val);
        preIndex.val++;
        root.left = buildTreeUtil(in, pre, startIn, inorderIndex - 1, preIndex);
        root.right = buildTreeUtil(in, pre, inorderIndex + 1, endIn, preIndex);
        return root;
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        PreIndex preIndex = new PreIndex();
        return buildTreeUtil(inorder, preorder, 0, n - 1, preIndex);
    }
}