/*
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
The values smaller than root go to the left side
The values greater and equal to the root go to the right side

https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
*/

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            Node root = null;
            int sizeOfArray = sc.nextInt();
            int arr[] = new int[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                int x = sc.nextInt();
                arr[i] = x;
            }

            for (int i = 0; i < sizeOfArray; i++) {
                root = Geeks.newNode(root, arr[i]);
            }
            int l, h;
            l = sc.nextInt();
            h = sc.nextInt();
            System.out.println(Geeks.getCountOfNode(root, l, h));

        }
    }
}

class Geeks {
    public static Node createNewNode(int value) {
        Node temp = new Node(value);

        return temp;
    }

    static public Node newNode(Node root, int data) {
        if (root == null)
            root = createNewNode(data);
        else if (data < root.data)
            root.left = newNode(root.left, data);
        else
            root.right = newNode(root.right, data);

        return root;
    }

    public static int getCountOfNode(Node root, int l, int h) {
        if (root == null)
            return 0;
        if (root.data < l) {
            return getCountOfNode(root.right, l, h);
        } else if (root.data > h) {
            return getCountOfNode(root.left, l, h);
        } else {
            return 1 + getCountOfNode(root.right, l, h) + getCountOfNode(root.left, l, h);
        }
    }

}