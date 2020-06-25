
/*
How to implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/*
array  (deletion is O(n))
linked list  (deletion can be O(1) but previous can be found in O(n))
doubly linked list   (deletion O(1) and previous can be found in O(1))
*/

class DllNode {
    int data;
    DllNode prev, next;

    DllNode(int d) {
        data = d;
        next = prev = null;
    }
}

class SpecialStack {
    DllNode top = null;
    DllNode mid = null;
    int size = 0;

    int getMideleElement() {
        if (mid != null)
            return mid.data;
        return -1;
    }

    int removeMideleElement() {
        if (size == 0)
            return -1;
        else if (size == 1) {
            int temp = mid.data;
            mid = top = null;
            size--;
            return temp;
        } else {
            DllNode temp = mid;
            DllNode prev = mid.prev;
            DllNode next = mid.next;
            // attach prev and next of mid
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            // Update mid
            if (size % 2 == 0) {
                mid = mid.next;
            } else {
                mid = mid.prev;
            }
            // Update size
            size--;
            return temp.data;
        }
    }

    void push(int x) {
        if (size == 0) {
            mid = top = new DllNode(x);
        } else {
            // add element
            DllNode newNode = new DllNode(x);
            top.next = newNode;
            newNode.prev = top;
            top = top.next;

            // update mid
            if (size % 2 == 0) {
                mid = mid.next;
            }
        }
        size++;
    }

    int pop() {
        if (size == 0) {
            return -1;
        }
        int data = top.data;
        if (size == 1) {
            mid = top = null;
        } else {
            // update top
            top = top.prev;
            top.next = null;

            // update mid
            if (size % 2 == 1) {
                mid = mid.prev;
            }
        }
        // update size
        size--;
        return data;
    }
}

class Driver {
    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();
        StringBuffer sb = new StringBuffer();
        // 1 for push, 2 pop, 3 getMin, 4 removeMin

        sb.append(stack.getMideleElement() + " ");
        stack.push(10);
        sb.append(stack.getMideleElement() + " ");
        stack.push(20);
        sb.append(stack.getMideleElement() + " ");
        stack.removeMideleElement();
        sb.append(stack.getMideleElement() + " ");
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.pop();
        sb.append(stack.getMideleElement() + " ");
        stack.pop();
        stack.pop();
        stack.pop();
        sb.append(stack.getMideleElement() + " ");

        StringBuffer result = new StringBuffer("-1 10 10 20 30 -1 ");

        System.out.print(sb.toString().equals(result.toString()));
    }
}