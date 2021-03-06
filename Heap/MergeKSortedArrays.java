/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1#
*/

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


class Triplet implements Comparable<Triplet> {
    int i,j,val;
    Triplet(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
    
    public int compareTo(Triplet other){
        return this.val - other.val;
    }
}

class Solution{
    
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Triplet(i,0,arrays[i][0]));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(pq.size() >0){
            Triplet curr = pq.poll();
            result.add(curr.val);
            if(curr.j+1<k){
                pq.add(new Triplet(curr.i,curr.j+1,arrays[curr.i][curr.j+1]));
            }
        }
        
        return result;
    }
}