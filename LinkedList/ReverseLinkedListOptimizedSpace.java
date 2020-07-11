/*
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.
https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
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

class Is_LinkedList_Palindrom {
    Node head;
    Node tail;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            // int k = sc.nextInt();
            Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            Palindrome g = new Palindrome();
            if (g.isPalindrome(head) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }

    }
}

class Palindrome {

    Node reverseLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev, curr, next;
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

    boolean isEqualLL(Node headA, Node headB) {

        while (headA != null && headB != null) {
            if (headA.data != headB.data)
                return false;
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headA == headB;
    }

    /*
     * Idea is to find mid element and reverse one half and cmpare with other half
     * for even slow will point end of first half for odd second half must start
     * from slow.next.next
     */
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node fast, slow, secondHalf, reversedLL;
        fast = slow = head;

        // get last of first half in slow pointer
        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            // move slow for even count (including fast.next)
            if (fast != null && fast.next != null) {
                slow = slow.next;
            }
        }

        // odd
        if (fast != null) {
            secondHalf = slow.next.next;
        } else {
            // even
            secondHalf = slow.next;
        }

        // break linked list from half
        slow.next = null;

        // reverse first half
        reversedLL = reverseLL(head);
        return isEqualLL(reversedLL, secondHalf);
    }
}