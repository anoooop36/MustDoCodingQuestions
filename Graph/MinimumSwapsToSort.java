/*
Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
https://practice.geeksforgeeks.org/problems/minimum-swaps/1
*/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}


class Pair implements Comparable<Pair> {
    int val;
    int index;
    Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
    
    public int compareTo(Pair other){
        return this.val - other.val;
    }
}

class Solution
{
	/*
		idea is to find length of each cycle (which requires swap)
	*/
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        Pair[] tempArr = new Pair[n];
        
        for(int i=0; i<n; i++){
            tempArr[i]= new Pair(nums[i],i);
        }
        
        Arrays.sort(tempArr);
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int swaps = 0;
        
        for(int i=0; i<n; i++){
			
            if(!visited[i]){
				
                int cycleSize = 0;
                int curr = i;
				
                while(!visited[curr]){
                    cycleSize++;
                    visited[curr] = true;
                    curr = tempArr[curr].index;
                }
                swaps += (cycleSize-1);
            }
        }
        
        return swaps;
    }
}