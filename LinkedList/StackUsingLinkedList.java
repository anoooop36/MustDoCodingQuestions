/*
Let's give it a try! You have a linked list and you have to implement the functionalities push and pop of stack using this given linked list.
https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
*/

import java.util.*;

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}
// } Driver Code Ends

/*
 * The structure of the node of the stack is class StackNode { int data;
 * StackNode next; StackNode(int a) { data = a; next = null; } }
 */
class MyStack {

    // Note that top is by default null
    // in Java
    StackNode top;

    void push(int a) {
        if (top == null)
            top = new StackNode(a);
        else {
            StackNode stNode = new StackNode(a);
            stNode.next = top;
            top = stNode;
        }
    }

    int pop() {
        if (top == null)
            return -1;
        int num = top.data;
        if (top.next == null)
            top = null;
        else
            top = top.next;
        return num;
    }
}