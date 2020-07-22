/*
Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree.

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5

https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
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

class GfG {

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

            if (g.isBalanced(root) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}

class Height {
    int val = 0;
}

class Tree {

    /*
     * idea is to do post order traversal and for a node get left subtree height and
     * right subtree height if abs(leftHeight-rightHeight) <= 1 and left subtree and
     * right subtree are balanced than current node is balanced updat height of
     * current node accordingly (make decisions from bottom up manner)
     */
    boolean isBalancedUtil(Node root, Height height) {

        if (root == null)
            return true;

        Height leftHeight = new Height();
        Height rightHeight = new Height();

        if (isBalancedUtil(root.left, leftHeight) && isBalancedUtil(root.right, rightHeight)) {
            if (Math.abs(leftHeight.val - rightHeight.val) <= 1) {
                height.val = 1 + Math.max(leftHeight.val, rightHeight.val);
                return true;
            }
            return false;
        }
        return false;
    }

    boolean isBalanced(Node root) {
        return isBalancedUtil(root, new Height());
    }
}