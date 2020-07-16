/*
Complete the function to print spiral order traversal of a tree.
The tree is
                           10
                        /        \
                     20            30
                  /       \
               40          60
So, the spiral level order would be 10 20 30 60 40
https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Spiral g = new Spiral();
            g.printSpiral(root);
            System.out.println();

        }
    }
}

class Spiral {

    /*
        Idea is to use two stacks. first Stack to print from left to right. Second to print from right to left
        intially first will have root.
        while both stacks are not empty
            print top of first and push its right and left to second, while first is not empty
            print top of second and push its left and right to first, while second is not empty
    */
    void printSpiral(Node node) {

        if (node == null)
            return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        StringBuffer sb = new StringBuffer();

        st1.push(node);

        while (st1.size() > 0 || st2.size() > 0) {

            while (st1.size() > 0) {
                sb.append(st1.peek().data + " ");
                Node curr = st1.pop();
                if (curr.right != null)
                    st2.push(curr.right);
                if (curr.left != null)
                    st2.push(curr.left);
            }

            while (st2.size() > 0) {
                sb.append(st2.peek().data + " ");
                Node curr = st2.pop();
                if (curr.left != null)
                    st1.push(curr.left);
                if (curr.right != null)
                    st1.push(curr.right);
            }
        }

        System.out.print(sb);
    }
}