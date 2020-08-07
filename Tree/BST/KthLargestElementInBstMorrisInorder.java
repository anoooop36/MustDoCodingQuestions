/*
Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.
https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine());

            Tree g = new Tree();
            System.out.println(g.kthLargest(root, k));
            t--;
        }
    }
}



class Tree {

    // since we need to go back after traversing right subtree we need stack or
    // recursion or thread (from successor)
    // we need to remove thread while going back (can be identitied if
    // successor.left is not null)
    public int morrisInorderTraversal(Node root, int k) {
        if (root == null)
            return -1;

        Node current = root;

        while (current != null) {

            if (current.right == null) {
                // print current data
                if (--k == 0)
                    return current.data;
                current = current.left;
            } else {

                // get inorder successor
                Node succ = current.right;
                while (succ.left != null && succ.left != current) {
                    succ = succ.left;
                }
                // succ left is null then first time visit so add current to left of succ
                // (thread) and go to left
                // succ left is not null then remove thread from succ and go to right
                if (succ.left == null) {
                    succ.left = current;
                    current = current.right;
                } else {
                    // print current data
                    // remove thread
                    succ.left = null;
                    if (--k == 0)
                        return current.data;
                    current = current.left;
                }

            }

        }
        return -1;
    }

    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        return morrisInorderTraversal(root, k);
    }
}