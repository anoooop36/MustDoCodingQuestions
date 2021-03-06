/*
Given an input stream of N integers. 
The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1

*/

import java.util.*;
import java.io.*;
import java.lang.*;


class Driverclass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            FindMedian Ans = new FindMedian();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                Ans.insertHeap(x);
                System.out.println((int)Math.floor(Ans.getMedian()));
            }
        }
        
        
    }
}



class FindMedian
{
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    
    // Function to insert heap
    public static void insertHeap(int x)
    {
        if(max.size() == 0)
            max.add(x);
        else if(max.peek() > x){
            max.add(x);
        } else {
            min.add(x);
        }
        balanceHeaps();
    }
    
     // Function to balance Heaps
    public static void balanceHeaps()
    {
       if(max.size() > min.size()+1){
           min.add(max.poll());
       } else if(max.size()+1 < min.size()){
           max.add(min.poll());
       }
    }
    
    // function to getMedian
    public static double getMedian()
    {
        if(max.size() == min.size())
            return (max.peek()+min.peek())/2;
        if(max.size() > min.size())
            return max.peek();
        return min.peek();
    }
    
}