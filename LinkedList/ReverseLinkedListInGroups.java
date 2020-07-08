    /*
    Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
    https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
    */
    
    import java.util.*;
    import java.lang.*;
    
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    class ReverseInSize
    {
        static Node head;
        
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                int a1 = sc.nextInt();
                Node head = new Node(a1);
                Node tail = head;
                for(int i = 1; i < n; i++)
                {
                    int a = sc.nextInt();
                    // addToTheLast(new Node(a));
                    tail.next = new Node(a);
                    tail =tail.next;
                }
                
                int k = sc.nextInt();
                GfG gfg = new GfG();
                Node res = gfg.reverse(head, k);
                printList(res);
                System.out.println();
            }
        }
        
        public static void printList(Node node)
        {
            while(node != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
        
    }
    
    
    class GfG
    {
        /*
            do reverse of first k elements using three pointers (previous, current, next)
            now current will be pointing to k+1th element.
            head should point to reverse(k+1th node)
            return previous as new head
        */
        public static Node reverse(Node head, int k)
        {
            if(head == null)
                return null;
            
            Node prev = null;
            Node curr = head;
            Node next = curr.next;
            int count = 0;
            
            while(curr != null && count < k){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null)
                    next = next.next;
                count++;
            }
            head.next = reverse(curr,k);
            return prev;
        }
    }