/*
Given a Linked List of size N, where every node represents a linked list and contains two pointers of its type:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.

You have to flatten the linked list to a single linked list which should be sorted.
And after flattening the above list, the sorted linked list looks like:

 5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.

Note: The flattened list will be printed using the bottom pointer instead of next pointer.
https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
*/
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}// } Driver Code Ends


class GfG
{
    Node mergeLists(Node root, Node rightList){
        if(root == null)
	        return rightList;
	   	if(rightList == null){
	        return root;
	    }

	    Node flattenList = null;
	    Node head = null;
	    
	    while(root != null && rightList!= null){
	        if(flattenList == null){
	            if(root.data < rightList.data){
	                flattenList = root;
	                root = root.bottom;
	            } else {
	                flattenList = rightList;
	                rightList = rightList.bottom;
	            }
	            head = flattenList;
	        } else {
	            if(root.data < rightList.data){
	                flattenList.bottom = root;
	                root = root.bottom;
	                
	            } else {
	                flattenList.bottom = rightList;
	                rightList = rightList.bottom;
	            }
	            flattenList = flattenList.bottom;
	        }
	    }
	    
	    while(root != null ){
	        if(flattenList == null){
                flattenList = root;
                root = root.bottom;
                head = flattenList;
	        } else {
                flattenList.bottom = root;
                root = root.bottom;
	            flattenList = flattenList.bottom;
	        }
	    }
	    while(rightList != null ){
	        if(flattenList == null){
                flattenList = rightList;
                rightList = rightList.bottom;
                head = flattenList;
	        } else {
                flattenList.bottom = rightList;
                rightList = rightList.bottom;
	            flattenList = flattenList.bottom;
	        }
	    }
	    return head;
    }
    Node flatten(Node root)
    {
	    if(root == null || root.next == null)
	        return root;
	   
	   Node first, second, third;
	   first = root;
	   second = root.next;
	   third = root.next.next;
	   
	    while(second != null){
	        first = mergeLists(first, second);
	        second = third;
	        if(third != null){
	            third = third.next;
	        }
	    }
	    return first;
    }
}