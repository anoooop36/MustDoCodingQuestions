/*
A binary heap is a Binary Tree with the following properties:
1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at the root must be minimum among all keys present in Binary Heap.
The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

You are given an empty Binary Min Heap and some queries and your task is to implement the three methods insertKey,
deleteKey,  and extractMin on the Binary Min Heap and call them as per the query given below:
1) 1  x  (a query of this type means to insert an element in the min-heap with value x )
2) 2  x  (a query of this type means to remove an element at position x from the min-heap)
3) 3  (a query like this removes the min element from the min-heap and prints it ).

https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap/1#
*/

import java.util.*;
import java.io.*;

class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            MinHeap h = new MinHeap(a);
            for (int i = 0; i < a; i++) {
                int c = sc.nextInt();
                int n;
                if (c == 1) {
                    n = sc.nextInt();

                    h.insertKey(n);
                }
                if (c == 2) {
                    n = sc.nextInt();
                    h.deleteKey(n);
                }
                if (c == 3) {
                    System.out.print(h.extractMin() + " ");
                }
            }
            System.out.println();
        }
    }
}

class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    // You need to write code for below three functions
    int extractMin() {
        if(heap_size ==0)
            return -1;
        int min = harr[0];
        if(heap_size >  1){
            harr[0] = harr[heap_size-1];
            harr[heap_size-1] = min;
        }
        heap_size--;
        MinHeapify(0);
        return min;
    }

    void insertKey(int k) {
        if(heap_size < capacity){
            harr[heap_size++] = k;
            heapifyUp(heap_size-1);
        }
    }

    void deleteKey(int i) {
        if(i<heap_size){
            decreaseKey(i,Integer.MIN_VALUE);
            extractMin();
        }
    }

    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }
    
    void heapifyUp(int i) {
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}