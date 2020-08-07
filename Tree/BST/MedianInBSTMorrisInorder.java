/*
Given a Binary Search Tree, find the Median of its Node values.
https://practice.geeksforgeeks.org/problems/median-of-bst/1
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
            g.findMedian(root);
            System.out.println();
            t--;

        }
    }
}
// } Driver Code Ends

class Tree {
    static int morrisInorderTraversal(Node root) {

        if (root == null)
            return 0;

        int count = 0;
        while (root != null) {
            if (root.left == null) {
                count++;
                root = root.right;
            } else {
                Node pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    count++;
                    root = root.right;
                }
            }

        }
        return count;
    }

    static void morrisInorderTraversalMedian(Node root, int n, Node firstMedian, Node secondMedian) {
        if (root == null)
            return;
        while (root != null) {
            if (root.left == null) {
                if (--n == 0) {
                    firstMedian.data = root.data;
                }
                if (n == -1) {
                    secondMedian.data = root.data;
                    return;
                }
                root = root.right;
            } else {
                Node pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    if (--n == 0) {
                        firstMedian.data = root.data;
                    }
                    if (n == -1) {
                        secondMedian.data = root.data;
                        return;
                    }
                    root = root.right;
                }
            }

        }
    }

    public static void findMedian(Node root) {
        int nodeCount = morrisInorderTraversal(root);
        Node firstMedian = new Node(-1);
        Node secondMedian = new Node(-1);
        morrisInorderTraversalMedian(root, (int) Math.ceil(nodeCount / 2.0), firstMedian, secondMedian);
        if (nodeCount % 2 == 1)
            System.out.print(firstMedian.data);
        else {
            int total = firstMedian.data + secondMedian.data;
            if ((total) % 2 == 0) {
                System.out.print(total / 2);
            } else
                System.out.print((total) / 2.0);
        }
    }
}