
/*
Given inorder and postorder traversals of a Binary Tree in the arrays in[] and post[] respectively. 
The task is to construct the binary tree from these traversals.
For example, if given inorder and postorder traversals are {4, 8, 2, 5, 1, 6, 3, 7} and {8, 4, 5, 2, 6, 7, 3, 1}  respectively, 
then your function should construct below tree.

          1
       /      \
     2        3
   /    \     /   \
  4     5   6    7
    \
      8
*/
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++)
                inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

class PostIndex {
    int val;
}

class GfG {
    
    int findInorderIndex(int in[], int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (in[i] == val)
                return i;
        }
        return -1;
    }

    /*
     * Idea is take each element from post order from rightmost, create a tree node
     * using it, find its index in inorder and build left and right subtree. We need
     * to maitain start and end inroder index so that we don't need to look in
     * entier array to divide it. We need three indexs startIn, endIn, postIndex.
     * PostIndex used to get next root.
     */
    Node buildTreeUtil(int in[], int post[], int start, int end, PostIndex postIndex) {
        if (start > end || postIndex.val < 0)
            return null;
        int val = post[postIndex.val];
        postIndex.val--;
        Node root = new Node(val);
        int inorderIndex = findInorderIndex(in, start, end, val);
        root.right = buildTreeUtil(in, post, inorderIndex + 1, end, postIndex);
        root.left = buildTreeUtil(in, post, start, inorderIndex - 1, postIndex);
        return root;
    }

    Node buildTree(int in[], int post[], int n) {
        PostIndex postIndex = new PostIndex();
        postIndex.val = n - 1;
        return buildTreeUtil(in, post, 0, n - 1, postIndex);
    }
}