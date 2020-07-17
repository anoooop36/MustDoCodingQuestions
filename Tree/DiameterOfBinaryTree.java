/*
Given a Binary Tree, find diameter of it.
+The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. 
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest 
path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

                           10
                        /        \
                     20         30
                  /       \
               40       60
The diameter is of 4 length.

https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
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
            System.out.println(g.diameter(root));
            t--;
        }
    }
}



class Max {
    int val = Integer.MIN_VALUE;
}

class Tree {
    /*
     * during postorder traversal maintain max diameter so far. For a node dia will
     * be 1 + leftMax + rightMax function should return height of currentNode which
     * will be used by its parent to compute dia.
     */
    int diameterUtil(Node root, Max max) {
        if (root == null)
            return 0;

        int leftHeight = diameterUtil(root.left, max);
        int rightHeight = diameterUtil(root.right, max);

        int currDiameter = 1 + leftHeight + rightHeight;
        if (max.val < currDiameter)
            max.val = currDiameter;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int diameter(Node root) {
        Max max = new Max();
        diameterUtil(root, max);
        return max.val;
    }
}