/*
Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.
https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
*/

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        	int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            Solution g = new Solution();
            head = g.pairwiseSwap(head);
            printList(head); 
            t--;
        }
    } 
} 
 


class Solution {
    
    /*
        let curr pointing to head swap data of curr and next then move curr to next of next
    */
    public Node pairwiseSwap(Node head)
    {
        Node curr = head;
        while(curr != null && curr.next != null){
                int temp = curr.data;
                curr.data = curr.next.data;
                curr.next.data = temp;
                curr = curr.next.next;
        }
        return head;
    }
}