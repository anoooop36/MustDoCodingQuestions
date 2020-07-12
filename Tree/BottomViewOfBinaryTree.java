/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. 
For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data; // data of the node
    int hd; // horizontal distance of the node
    Node left, right; // left and right references

    // Constructor of tree node
    public Node(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> res = g.bottomView(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}


class Pair {
    Node node;
    int verticalDistance;

    Pair(Node n, int vd) {
        node = n;
        verticalDistance = vd;
    }
}

class Tree {
    int minHd;
    int maxHd;

    /*
     * we need highest level node for each of the horizontal disance. so two
     * variables hd and vd required in recusion to maintain horizontal distance and
     * vertical distance Use hashMap to keep node correspoinding to paritcular
     * horizontal distance get minHd and maxHd, will be required to print from
     * leftmost to rightmost
     * 
     * alternate is Use TreeMap but complexity will be nlogn
     */
    void bottomViewUtil(Node root, int vd, int hd, HashMap<Integer, Pair> map) {
        if (root == null)
            return;

        bottomViewUtil(root.left, vd + 1, hd - 1, map);

        Pair oldPair = map.get(hd);
        if (oldPair == null || oldPair.verticalDistance <= vd) {
            map.put(hd, new Pair(root, vd));
        }

        if (minHd > hd) {
            minHd = hd;
        }
        if (maxHd < hd) {
            maxHd = hd;
        }

        bottomViewUtil(root.right, vd + 1, hd + 1, map);
    }

    // Method that returns the bottom view.
    public ArrayList<Integer> bottomView(Node root) {
        HashMap<Integer, Pair> map = new HashMap<>();
        minHd = Integer.MAX_VALUE;
        maxHd = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<Integer>();
        bottomViewUtil(root, 0, 0, map);
        for (int i = minHd; i <= maxHd; i++) {
            res.add(map.get(i).node.data);
        }
        return res;
    }
}