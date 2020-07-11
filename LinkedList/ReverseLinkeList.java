/*
Given a linked list of N nodes. The task is to reverse this list.
https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
*/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {

            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            ReverseLL g = new ReverseLL();
            head = g.reverseList(head);
            printList(head);
            t--;
        }
    }
}

class ReverseLL {
    /*
     * Three pointer solution, previous, current, next. previous keep track to last
     * reverse linked list, current refers to current node whose next pointer should
     * be changed, next is used to keep track of none reverse linked list
     */
    Node reverseList(Node head) {
        if (head == null)
            return null;

        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        return prev;
    }
}