/*
Given a BST and a key. Insert a new Node with value equal to that key into the BST. 
https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
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

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
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

                // Create the right child for the current node
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
            int key = Integer.parseInt(br.readLine().trim());
            Solution T = new Solution();
            root = T.insert(root, key);
            inorder(root);
            System.out.println();
            t--;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class Solution {

    Node insert(Node root, int Key)
    {
        if(root == null){
            return new Node(Key);
        }
        
        if(root.data < Key){
            root.right = insert(root.right, Key);
        } else if(root.data > Key){
            root.left = insert(root.left, Key);
        }
        return root;
    }

    Node insertNonRecursive(Node root, int Key) {
        if (root == null) {
            return new Node(Key);
        }

        Node prev = null;
        Node temp = root;
        while (temp != null) {
            prev = temp;
            if (temp.data == Key)
                return root;
            else if (temp.data < Key) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        if (prev.data > Key) {
            prev.left = new Node(Key);
        } else if (prev.data < Key) {
            prev.right = new Node(Key);
        }
        return root;
    }
}