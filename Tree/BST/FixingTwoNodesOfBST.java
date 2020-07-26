/*
Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
*/

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

class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
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

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null)
            return true;
        if (n.data <= lower || n.data >= upper)
            return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }

        return (compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Sol g = new Sol();

            root = g.correctBST(root);

            // check 1: is tree now a BST
            if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false) {
                System.out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree

            ArrayList<pair> mismatch = new ArrayList<pair>();
            // an arraylist to store data of mismatching nodes

            if (compare(root, duplicate, mismatch) == false) {
                // false output from this function indicates change in structure of tree
                System.out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 || mismatch.get(0).first != mismatch.get(1).second
                    || mismatch.get(0).second != mismatch.get(1).first)
                System.out.println(0);
            else
                System.out.println(1);

        }
    }
}



class NodeRef {
    Node node = null;
}

class Sol {

    /*
        inorder traversal gives sorted list. So maintain previous node during inorder and use it to find current node is incorrect or not
        Use two refrences First and second to keep incorrect nodes
    */
    public void findSwappedNodes(Node root, NodeRef prev, NodeRef first, NodeRef sec) {
        if (root == null)
            return;

        findSwappedNodes(root.left, prev, first, sec);
        
        if (prev.node != null) {
            // one or both are incorrect ( handle base case of two nodes)
            if (prev.node.data > root.data) {
                //no need to update first if its already found
                if (first.node == null) {
                    first.node = prev.node;
                    sec.node = root;
                } else {
                    sec.node = root;
                }
            }
        }
        prev.node = root;
        
        findSwappedNodes(root.right, prev, first, sec);
    }

    public Node correctBST(Node root) {
        NodeRef prev = new NodeRef();
        NodeRef first = new NodeRef();
        NodeRef sec = new NodeRef();
        findSwappedNodes(root, prev, first, sec);
        if (first.node != null) {
            int temp = first.node.data;
            first.node.data = sec.node.data;
            sec.node.data = temp;
        }
        return root;
    }
}