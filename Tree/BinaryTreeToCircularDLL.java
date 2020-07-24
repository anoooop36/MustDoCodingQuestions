/*
Given a Binary Tree of N edges. The task is to convert this to a Circular Doubly Linked List(CDLL) in-place. 
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted CDLL. 
The order of nodes in CDLL must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal (left most node in BT) must be head node of the CDLL.

https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1
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

    static void displayCList(Node head) {
        Node itr = head;
        do {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head != itr);
        System.out.println();
        itr = itr.left;
        do {
            System.out.print(itr.data + " ");
            itr = itr.left;
        } while (head != itr);
        System.out.println(itr.data + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree boj = new Tree();
            Node head = boj.bTreeToClist(root);
            displayCList(head);

        }

    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

// User function Template for Java
/*
 * Node defined as class Node{ int data; Node left,right; Node(int d){ data=d;
 * left=right=null; } }
 */
class NodeRef {
    Node node = null;
}

class Tree {

    // convert tree to dll
    void bTreeDLLUtil(Node root, NodeRef head, NodeRef prev) {
        if (root == null)
            return;
        bTreeDLLUtil(root.left, head, prev);
        if (head.node == null) {
            head.node = root;
        } else {
            prev.node.right = root;
            root.left = prev.node;
        }
        prev.node = root;
        bTreeDLLUtil(root.right, head, prev);
    }

    // connect head and tail of DLL
    Node bTreeToClist(Node root) {
        NodeRef head = new NodeRef();
        NodeRef prev = new NodeRef();
        bTreeDLLUtil(root, head, prev);
        if (head.node != null && prev.node != null) {
            head.node.left = prev.node;
            prev.node.right = head.node;
        }
        return head.node;
    }

}