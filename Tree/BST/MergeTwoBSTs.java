/*
Given two BST, Return elements of both BSTs in sorted form.
https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
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

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
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

                // Create the right child for the curr node
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
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}



class Solution {

    
    void pushLeftNodes(Stack<Node> st, Node root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    /*
        Three ways to solve this problem
        1) Keep inorder of both BSTs in two arrays. Then merge two arrays . O(2n) time and O(2n) space
        2) Convert BSTs into DLL and merge them. O(n) time and O(h1+h2) space
        3) Use two stacks to keep all leftmost nodes from both roots. 
           Remove min node from one of the stacks then print that node and push all leftmost nodes of its right subtree.
           O(n) complexity, single iteration and O(h1+h2) space. 
    */
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        int min1, min2;
        pushLeftNodes(st1, root1);
        pushLeftNodes(st2, root2);
        while (st1.size() > 0 || st2.size() > 0) {
            min1 = st1.size() > 0 ? st1.peek().data : Integer.MAX_VALUE;
            min2 = st2.size() > 0 ? st2.peek().data : Integer.MAX_VALUE;
            if (min1 < min2) {
                list.add(min1);
                Node curr = st1.pop();
                pushLeftNodes(st1, curr.right);
            } else {
                list.add(min2);
                Node curr = st2.pop();
                pushLeftNodes(st2, curr.right);
            }
        }
        return list;
    }
}