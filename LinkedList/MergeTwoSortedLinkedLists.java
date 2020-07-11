/*
Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the list (in-place) and return head of the merged list.
Note: It is strongly recommended to do merging in-place using O(1) extra space.
https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
*/

import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



  /* Function to print linked list */
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
			Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1,head2);
			printList(head);
			
			t--;
			
         }
    }
}
// } Driver Code Ends


class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
        Node head, temp;
        head = temp = null;
        
        while(headA != null && headB!= null){
            if(headA.data < headB.data){
                if(temp == null){
                    temp = headA;
                    head = temp;
                    headA = headA.next;
                } else {
                    temp.next = headA;
                    temp = temp.next;
                    headA = headA.next;
                }
            } else {
                if(temp == null){
                    temp = headB;
                    head = temp;
                    headB = headB.next;
                } else {
                    temp.next = headB;
                    temp = temp.next;
                    headB = headB.next;
                }
            }
        }
        
        if(headA != null){
            if(temp == null){
                temp = headA;
                head = temp;
            } else {
                temp.next = headA;
            }
        }
        
        if(headB != null){
            if(temp == null){
                temp = headB;
                head = temp;
            } else {
                temp.next = headB;
            }
        }
        return head;
   }
}