/*
Given a Binary Search Tree (BST) and a node value. Delete the node with the given value from the BST. 
If no node with value x exists, then do not make any change. 

https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            Node root = buildTree(s);
            Tree g = new Tree();
            root = g.deleteNode(root, x);
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

class Tree {
    static Node findMin(Node root) {
        if (root == null)
            return null;

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /*
        Main idea is to find successor and delete successor after swapping value with root. Successor will not have any left child.
        if we maintain parent for inorder successor node we can easily delete during finding inorder successor node.
        No need to call delete on successor's value.
     */
    public static Node deleteNode(Node root, int x) {
        if (root == null)
            return root;
        if (root.data < x) {
            root.right = deleteNode(root.right, x);
        } else if (root.data > x) {
            root.left = deleteNode(root.left, x);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node parent = root;
                Node successor = root.right;
                while(successor.left != null){
                    parent = successor;
                    successor = successor.left;
                }

                if(parent != root)
                    parent.left = successor.right;
                else
                    root.right = successor.right;
                root.data = successor.data;
            }
        }
        return root;
    }
}
