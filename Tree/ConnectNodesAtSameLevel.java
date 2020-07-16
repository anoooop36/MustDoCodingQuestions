/*
iven a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.
Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
       10                           10 ------> NULL
      / \                       /      \
     3   5       =>             3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2                4 --> 1 -----> 2 -------> NULL
https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
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

    public static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void printSpecial(Node root) {
        if (root == null)
            return;

        Node next_root = null;

        while (root != null) {
            System.out.print(root.data + " ");

            if (root.left != null && next_root == null)
                next_root = root.left;
            else if (root.right != null && next_root == null)
                next_root = root.right;

            root = root.nextRight;
        }

        printSpecial(next_root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            g.connect(root);
            printSpecial(root);
            System.out.println();
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}

class Tree {

    /*
        Use queue for level order traversal.
        remove one element from queue and attach it to first or queue (if removed element is not null)
    */
    public static void connect(Node p) {
        if (p == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(p);
        q.add(null);

        while (q.size() > 0) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.size() > 0)
                    q.add(null);
            } else {
                curr.nextRight = q.peek();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }
}