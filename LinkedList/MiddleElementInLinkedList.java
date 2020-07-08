/*
Given a singly linked list of N nodes. The task is to find the middle of the linked list. For example, 
if given linked list is 1->2->3->4->5 then the output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, 
if given linked list is 1->2->3->4->5->6 then the output should be 4.
https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
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
            int ans = g.getMiddle(head);
            System.out.println(ans);
            //printList(head); 
            t--;
        }
    } 
} 
   // } Driver Code Ends



class Solution
{
    /*
        Two pointer solution one is fast and other is slow. fast moves twice as speed of slow. slow moves by one
        if no of nodes even it gives second mid. (to get first mid, add condition fast.next != null in while condition)
    */
    int getMiddle(Node head)
    {
         Node slowPtr, fastPtr;
         slowPtr = fastPtr = head;
         while(fastPtr != null){
             fastPtr = fastPtr.next;
             if(fastPtr != null){
                 slowPtr = slowPtr.next;
                 fastPtr = fastPtr.next;
             }
         }
         if(slowPtr != null)
            return slowPtr.data;
         return -1;
    }
}