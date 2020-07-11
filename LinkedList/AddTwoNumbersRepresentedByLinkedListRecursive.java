/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. 
The sum list is a linked list representation of the addition of two input numbers.
https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
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

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends

class Solution {

    static Node reverseLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev, next, curr;
        prev = null;
        curr = head;
        next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        return prev;
    }

    static Node addTwoListsUtil(Node first, Node second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

        int sum = first.data + second.data;
        int carry = sum / 10;
        Node newNode = new Node(sum % 10);
        newNode.next = addTwoListsUtil(first.next, second.next);
        if (carry > 0) {
            newNode.next = addTwoListsUtil(newNode.next, new Node(carry));
        }
        return newNode;
    }

    /*
     * revers both number lists Add them, take care of carry return reverse sum list
     */
    static Node addLists(Node first, Node second) {

        Node firstRev = reverseLL(first);
        Node secondRev = reverseLL(second);
        Node res = addTwoListsUtil(firstRev, secondRev);

        return reverseLL(res);

    }
}