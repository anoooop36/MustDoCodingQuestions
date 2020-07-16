/*
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and 
next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of 
Inorder traversal (leftmost node in BT) must be the head node of the DLL.
                           10
                        /        \
                     20         30
                  /       \
               40       60

So, DLL would be 40<=>20<=>60<=>10<=>30.

https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
*/

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }

}

class BT_To_DLL {

    static Node buildTree(String str) throws IOException {

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

    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            GfG g = new GfG();

            Node ans = g.bToDLL(root);
            printList(ans);
            t--;
            System.out.println();
        }

    }
}
// } Driver Code Ends

class PrevNode {
    Node node = null;
}

class GfG {
    /*
     * idea is to do reverse inorder traversal (right, root, left) and maintain
     * previous node (inorder successor). convert root to dll by setting 
     * root.right = prev and prev.left = root, update prev = root
     * 
     * return prev (as head)
     */
    Node binaryTreeToDllUtil(Node root, PrevNode prev) {
        if (root == null)
            return root;

        if (root.right != null) {
            binaryTreeToDllUtil(root.right, prev);
        }

        root.right = prev.node;
        if (prev.node != null)
            prev.node.left = root;
        prev.node = root;

        if (root.left != null)
            binaryTreeToDllUtil(root.left, prev);

        return prev.node;
    }

    Node bToDLL(Node root) {
        return binaryTreeToDllUtil(root, new PrevNode());
    }
}