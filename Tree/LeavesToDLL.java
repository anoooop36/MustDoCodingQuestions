/*
Given a Binary Tree, the task is to extract all leaves of it in a Doubly Linked List (DLL). 
Note that the DLL needs to be created in-place. 
Assume that the node structure of DLL and Binary Tree is the same, only the meaning of left and right pointers are different. 
In DLL, left means previous pointer and right means next pointer. 
Head of DLL should point to the leftmost leaf and then in inorder traversal and so on.

https://practice.geeksforgeeks.org/problems/leaves-to-dll/1
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

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            Node head = g.convertToDLL(root);
            printInorder(root);
            System.out.println();
            Node curr = head;
            Node last = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                last = curr;
                curr = curr.right;
            }
            System.out.println();
            curr = last;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            System.out.println();
        }
    }
}


class RefNode {
    Node node = null;
}

class Tree {

    /*
        Order between removing leaf node from its parent and  connecting leaf nodes are important
        if we connect leaf nodes before detaching them  we might end up with cycle in tree.
        Any of the traversals can be used for coversion
        Need to maintain previous leaf node (to connect with current node).
    */
    void convertToDLLUtil(Node root, RefNode prev, RefNode head) {
        if (root == null)
            return;
        Node left = root.left;
        Node right = root.right;
        if (left != null || right != null) {
            if (left != null && left.left == null && left.right == null) {
                root.left = null;
            }

            if (right != null && right.left == null && right.right == null) {
                root.right = null;
            }
        }

        convertToDLLUtil(left, prev, head);
        if (left == null && right == null) {
            if (prev.node == null) {
                head.node = root;
            } else {
                prev.node.right = root;
                root.left = prev.node;
            }
            prev.node = root;
        }
        convertToDLLUtil(right, prev, head);
    }

    public Node convertToDLL(Node root) {
        RefNode prev = new RefNode();
        RefNode head = new RefNode();
        convertToDLLUtil(root, prev, head);
        return head.node;
    }

}