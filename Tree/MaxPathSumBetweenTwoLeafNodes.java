/*
Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
        -9
       /   \
      6     -10
      
answer is -13 for above tree

https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GFG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree g = new Tree();
            System.out.println(g.maxPathSum(root));
            t--;
        }
    }
}

class Max {
    int val = Integer.MIN_VALUE;
}

class Tree {
    /*
     * idea is to do postorder traversal and update max so for by root.data + leftMax + rightMax
     * leftMax is max path sum from root to a leaf in left
     * subtree. similarly rightMax is max path sum from root to leaf of right
     * subtree. max is keep track max so for found for particular root.
     * 
     * Important to handle single child node and no child node.
     */
    int maxPathSumUtil(Node root, Max max) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null)
            return root.data;

        if (root.left == null)
            return root.data + maxPathSumUtil(root.right, max);

        if (root.right == null)
            return root.data + maxPathSumUtil(root.left, max);

        int leftMax = maxPathSumUtil(root.left, max);
        int rightMax = maxPathSumUtil(root.right, max);

        int currPathSum = root.data + leftMax + rightMax;

        if (max.val < currPathSum)
            max.val = currPathSum;

        return root.data + Math.max(leftMax, rightMax);
    }

    int maxPathSum(Node root) {
        Max max = new Max();
        maxPathSumUtil(root, max);
        return max.val;
    }
}