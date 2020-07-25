/*
There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. 
In case, if the either of predecessor or successor is not found print -1.

https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Res {
    Node pre = null;
    Node succ = null;
}

class PreSucc {

    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Res p = new Res();
            Res s = new Res();
            for (int i = 0; i < n; i++) {

                int a = sc.nextInt();
                int a1 = sc.nextInt();

                char lr = sc.next().charAt(0);

                if (i == 0) {

                    root = new Node(a);

                    switch (lr) {

                        case 'L':
                            root.left = new Node(a1);
                            break;
                        case 'R':
                            root.right = new Node(a1);
                            break;
                    }
                } else {
                    insert(root, a, a1, lr);
                }
            }

            int key = sc.nextInt();
            GfG g = new GfG();
            g.findPreSuc(root, p, s, key);

            if (p.pre != null)
                System.out.print(p.pre.data + " ");
            else
                System.out.print("-1" + " ");

            if (s.succ != null)
                System.out.println(s.succ.data);
            else
                System.out.println("-1");

        }
    }
}


class GfG {
    static Node getMin(Node root) {
        if (root == null)
            return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static Node getMax(Node root) {
        if (root == null)
            return null;
        while (root.right != null)
            root = root.right;
        return root;
    }

    /*
        for predecessor if found nodes left is null we need to look into its parent (whose value is less than key nearest to found node)
        Similarly for successor we need to look to its parents.
        We can avoid this look back if we maintain pred and suc from beginig of search. In case required child is not null look in sub tree otherwise
        return maintained one.
        
                max1
              /
            node
                \
                max2    if max2 subtree is null look in max1
    */
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null)
            return;
        if (root.data < key) {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        } else if (root.data > key) {
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        } else {
            if (root.right != null)
                s.succ = getMin(root.right);
            if (root.left != null)
                p.pre = getMax(root.left);
        }
    }
}