/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
https://practice.geeksforgeeks.org/problems/largest-bst/1
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();
            System.out.println(T.largestBst(root));

            t--;
        }
    }
}

class Ref {
    Boolean isBst;
    int max;
    int min;
    int size;

    Ref(Boolean isBst, int min, int max, int size) {
        this.isBst = isBst;
        this.max = max;
        this.min = min;
        this.size = size;
    }
}

class Solution {
    
    /*
        idea is to do postorder traversal. compute largest bst for left subtree then right subtree. Use max from left and min from right subtree to
        decide current nodes is Bst or not. (Each recursion on subtree should provide min, max, size and isBst) to compute isBst size on current node.
    */
    static Ref largestBSTUtil(Node root) {

        if (root == null) {
            return new Ref(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        Ref left = largestBSTUtil(root.left);
        Ref right = largestBSTUtil(root.right);
        
        if (left.isBst == false || right.isBst == false) {
            return new Ref(false, 0, 0, Math.max(left.size, right.size));
        }
        
        if (root.data > left.max && root.data < right.min) {
            return new Ref(true, Math.min(left.min, root.data), Math.max(right.max, root.data),
                    1 + left.size + right.size);
        }
        
        return new Ref(false, 0, 0, Math.max(left.size, right.size));
    }

    static int largestBst(Node root) {
        Ref res = largestBSTUtil(root);
        return res.size;
    }

}