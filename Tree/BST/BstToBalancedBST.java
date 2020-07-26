/*
Given a Binary Search Tree of size N, that may be unbalanced. Your task is to complete the function buildBalancedTree(),
that convert the given BST into a balanced BST that has minimum possible height.
*/

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node right, left;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    static Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

    }

    int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;

            while (n-- > 0) {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            GfG gfg = new GfG();

            root = gfg.buildBalancedTree(root);
            // preOrder(root);
            BinarySearchTree bst = new BinarySearchTree();
            System.out.println(bst.height(root));
        }
    }

    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}



class GfG {
    void inorder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    Node buildBalancedBSTUtil(ArrayList<Integer> list, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));
        root.left = buildBalancedBSTUtil(list, start, mid - 1);
        root.right = buildBalancedBSTUtil(list, mid + 1, end);
        return root;
    }

    /*
        if we use mid of sorted elements of tree as root tree will become balanced (recursively for its subtrees too)
        inorder of BST gives sorted elements.
        mid in sorted list can be found in O(1)
    */
    Node buildBalancedTree(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildBalancedBSTUtil(list, 0, list.size() - 1);
    }
}