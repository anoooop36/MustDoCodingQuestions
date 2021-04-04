/*
Given an array containing N integers and an integer K., 
Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
*/

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}


            

class Solution{
    
   
    /*
		idea is maintain cumulative for each index in map and use it to get subarray.
		currenCumulativeSum - k is present in map implies subarray exists with given sum k.
	*/
    public static int lenOfLongSubarr (int A[], int N, int K) {
        int resultLength = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0,-1);
        
        int leftSum = 0;
        
        for(int i=0;i<N;i++){
            leftSum += A[i];
            if(map.containsKey(leftSum-K)){
                resultLength = Math.max(resultLength, i-(map.get(leftSum-K)));
            }
            if(!map.containsKey(leftSum))
                map.put(leftSum,i);
        }
        return resultLength;
    }
    
    
}