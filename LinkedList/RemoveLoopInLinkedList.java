/*
You are given a linked list of N nodes. The task is to remove the loop from the linked list, if present.
https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            solver x = new solver();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


class solver
{
    // if loop exists it return one of loop node
    static Node getLoopNode(Node head){
        if(head == null || head.next == null)
            return null;
        Node slow, fast;
        slow = head;
        fast = head.next;
        
        while(fast != null && fast != slow){
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        
        if(slow == fast)
            return slow;
        return null;
    }
    
    // counts no of nodes in loop
    static int countLoopNodes(Node head){
        Node temp = head.next;
        int count = 1;
        while(temp != head){
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    /*
        first get one of loop nodes
        Count no of nodes in loop using node obtained before
        take a pointer(second) at count-1 distance from head
        one pointer(first) at head
        move both pointers till second.next != first (at this point first will point entry of loop and second will point to last node of loop)
        set second.next = null;
    */
    public static void removeLoop(Node head){
        Node loopNode = getLoopNode(head);
        if(loopNode != null){
            int loopCount = countLoopNodes(loopNode);
            Node second = head;
            // move second pointer to distance loopCount-1
            while(loopCount > 1){
                second = second.next;
                loopCount--;
            }
            Node first = head;
            while(second.next != first){
                second = second.next;
                first = first.next;
            }
            second.next = null;
        }
    }
}