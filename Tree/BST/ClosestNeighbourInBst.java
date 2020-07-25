/*
Given a binary search tree and a number N. Your task is to complete the function findMaxforKey(), 
that find's the greatest number in the binary search tree that is less than or equal to N. Print the value of the element if it exists otherwise print -1.

https://practice.geeksforgeeks.org/problems/closest-neighbor-in-bst/1
*/

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }

}

class BST {
    public static Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;

            while (n-- > 0) {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            int N = sc.nextInt();

            GfG gfg = new GfG();
            System.out.println(gfg.findMaxforKey(root, N, n));
        }

    }
}


class GfG {

    /*
        maintain predecessor from begning of search if node found and its left is not null then solution is max of left subtree
        else return maintained predecessor (we need to look into its parents , nearest one of them is smaller)
    */
    static int findMaxforKeyUtil(Node root, int key, Node predecessor) {
        if (root == null) {
            if (predecessor != null)
                return predecessor.data;
            return -1;
        }
        if (root.data < key) {
            predecessor = root;
            return findMaxforKeyUtil(root.right, key, predecessor);
        } else if (root.data > key) {
            return findMaxforKeyUtil(root.left, key, predecessor);
        } else {
            if (root.left == null) {
                if (predecessor != null)
                    return predecessor.data;
                return -1;
            } else {
                // return max of left subtree
                predecessor = root.left;
                while (predecessor.right != null)
                    predecessor = predecessor.right;
                return predecessor.data;
            }
        }
    }

    public static int findMaxforKey(Node node, int val, int size) {
        return findMaxforKeyUtil(node, val, null);
    }
}