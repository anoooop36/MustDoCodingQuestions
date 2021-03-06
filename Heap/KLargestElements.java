/*
Given an array of N positive integers, print k largest elements from the array.
https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
*/

import java.util.*;
import java.io.*;


class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution T = new Solution();
            ArrayList<Integer> list = T.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}



class Solution
{
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        
        for(int i=k;i<n;i++){
            if(pq.peek() < arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(pq.size() > 0){
            res.add(pq.poll());
        }
        
        Collections.reverse(res);
        return res;
    }
}