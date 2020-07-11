/*
Given a linked list of N nodes. The task is to check if the the linked list has a loop. Linked list can contain self loop.
https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0)
            return;

        Node curr = head;
        for (int i = 1; i < x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            Solution x = new Solution();
            if (x.detectLoop(head))
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

class Solution {
    /*
     * Two pointer solution, fast and slow pointer. slow initialized to head and
     * fast initialized to head.next fast moves twice speed of slow. if theres no
     * loop they will not meet again otherwise they will meet at begining of loop.
     */
    public static boolean detectLoop(Node head) {

        if (head == null || head.next == null)
            return false;

        Node slowPtr, fastPtr;
        slowPtr = head;
        fastPtr = head.next;

        while (fastPtr != null && fastPtr != slowPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr != null)
                fastPtr = fastPtr.next;
        }

        return fastPtr == slowPtr;
    }
}