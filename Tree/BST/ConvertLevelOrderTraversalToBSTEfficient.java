/*
Given an array of size N containing level order traversal of a BST. The task is to complete the function constructBst(), 
that construct the BST (Binary Search Tree) from its given level order traversal.

                    7
                 /    \
                4       12
             /   \       /
            3    6       8
          /      /       \
         1       5       10


https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1
*/

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}


class NodeInfo {
    Node node;
    int max;
    int min;

    NodeInfo(Node node, int min, int max) {
        this.node = node;
        this.max = max;
        this.min = min;
    }
}

class GFG {

    public Node constructBST(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return null;
        Queue<NodeInfo> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        NodeInfo info = new NodeInfo(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        q.add(info);
        int i = 1;
        while (q.size() > 0) {
            NodeInfo currInfo = q.poll();
            Node node = currInfo.node;
            if (i < n && arr[i] < node.data && arr[i] > currInfo.min) {
                node.left = new Node(arr[i++]);
                q.add(new NodeInfo(node.left, currInfo.min, node.data));
            }
            if (i < n && arr[i] > node.data && arr[i] < currInfo.max) {
                node.right = new Node(arr[i++]);
                q.add(new NodeInfo(node.right, node.data, currInfo.max));
            }
        }
        return root;
    }
}