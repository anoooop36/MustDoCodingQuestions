/*
Given a binary tree. Check whether it is a BST or not.
https://practice.geeksforgeeks.org/problems/check-for-bst/1
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
            if (g.isBST(root))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}

// } Driver Code Ends

public class Tree {
    /*
     * for each root node its left and right subtrees should be bst and max from
     * left subtree must be less than root.data and min from right subtree mus be
     * greater than root.data. To get max from left subtree and min from
     * right subtree will require two refrences of min and max in recursion.
     *  Solve from top to bottom rather bottom to top (will not require to return min and max
     * from subtrees)
     */
    boolean isBstUtil(Node root, int min, int max) {
        if (root == null)
            return true;
        return root.data > min && root.data < max && isBstUtil(root.left, min, root.data)
                && isBstUtil(root.right, root.data, max);
    }

    // return true if the given tree is a BST, else return false
    boolean isBST(Node root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}