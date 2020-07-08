/*
Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise by k nodes, 
where k is a given positive integer smaller than or equal to length of the linked list.
https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
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

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Rotate g = new Rotate();
            head = g.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}


class Rotate{
    
    /*
        Three pointer solution. first points k-1th, second points to kth, tail points to last element
    */
    public Node rotateCounterClockwise(Node head, int k) {
        if(head == null)
            return null;
        
        Node first, second, tail;
        
        first = second = null;
        tail = head;
        
        while(tail.next != null){
            if(k == 1){
                first = tail;
            }
            tail = tail.next;
            k--;
        }
        
        if(k==1)
            return head;
        if(k>1)
            return null;   // shold throw
        
        second = first.next;
        tail.next = head;
        first.next = null;
        head = second;
 
        return head;
    }
    
    /*
        Three pointer solution. first points k-1th, second points to kth, tail points to last element
    */
    public Node rotateClockwise(Node head, int k) {
        if(head == null)
            return null;
        
        Node first, second, tail;
        first = tail = head;
        // move tail to k times
        while(tail != null && k>0){
            k--;
            tail = tail.next;
        }
        
        if(k!= 0)
            return null; // should throw
        if(tail == null)
            return head;
            
        //tail and first hould have diff of k and tail should point to last element of list
        while(tail.next != null){
            tail = tail.next;
            first = first.next;
        }
        
        // point second to kth element
        second = first.next;
        // make k-1th element as tail
        first.next = null;
        // attach tail to head
        tail.next = head;
        // change head to kth element
        head = second;
        
        return head;
    }
    
    public Node rotate(Node head, int k) {
        return rotateCounterClockwise(head, k);
    }
}