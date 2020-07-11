/*
You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. 
Pointer/ reference to head node is not given. 
Note: No head reference is given to you.
https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
*/

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Delete_Node {
    Node head;
    Node tail;

    void printList(Node head) {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    Node search_Node(Node head, int k) {
        Node current = head;
        while (current != null) {
            if (current.data == k)
                break;
            current = current.next;
        }
        return current;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Delete_Node llist = new Delete_Node();
            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            int k = sc.nextInt();
            Node del = llist.search_Node(llist.head, k);

            GfG g = new GfG();
            if (del != null && del.next != null) {
                g.deleteNode(del);
            }
            llist.printList(llist.head);
            t--;
        }
    }
}


// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class GfG {
    /*
     * idea is to replace value of current node with next then remove next node by
     * changing pointer of next in current
     */
    void deleteNode(Node node) {
        if (node == null || node.next == null)
            node = null; // should throw expception can't delete last node using pointer of last node

        else {
            node.data = node.next.data;
            node.next = node.next.next;
        }

    }
}