/*
    Given a Binary Search Tree (BST), write a function isTripletPresent() that returns true if there is a triplet in given BST with sum equals to 0, otherwise returns false.
    https://practice.geeksforgeeks.org/problems/three-numbers-sum-equal-to-0/1
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Triplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            GfG gfg = new GfG();
            boolean res = gfg.isTriplet(root);

            if (res == true)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static Node insert(Node root, int x) {
        if (root == null) {
            return (new Node(x));
        }

        if (x < root.data) {
            root.left = insert(root.left, x);
        } else if (x > root.data) {
            root.right = insert(root.right, x);
        }

        return root;
    }
}


class GfG {
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static boolean isTriplet(Node root) {
        list = new ArrayList<>();
        inorder(root);
        boolean res = isTripletUtil(root);
        return res;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }

    /*
        Extended two pointer solution to find triplet O(n2) on sorted array.
        if tree is balance convert tree to DLL using inorder and use Extended two pointer solution.
    */
    public static boolean isTripletUtil(Node root) {
        for (int i = 0; i < list.size() - 2; i++) {
            int j = i + 1;
            int k = list.size() - 1;
            while (j < k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if (sum == 0)
                    return true;
                if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return false;
    }
}