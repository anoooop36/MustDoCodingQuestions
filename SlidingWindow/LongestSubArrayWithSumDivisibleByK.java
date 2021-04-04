/*
Given an array containing N integers and a positive integer K, 
find the length of the longest sub array with sum of the elements divisible by the given value K.
https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
*/


import java.io.*;
import java.util.*;



class Solution{
	
	/*
		cumulativeSumI%k -cumulativeSumJ%k = 0
		if cumulativeSumI % k can be found in map then subarray exits
	*/
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        int resultLength = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(0,-1);
        
        int leftSum = 0;
        
        for(int i=0;i<n;i++){
            leftSum += a[i];
            int rem = ((leftSum%k)+k)%k;
            if(map.containsKey(rem)){
                resultLength = Math.max(resultLength,i-map.get(rem));
            } else {
                map.put(rem,i);
            }
        }
       
       return resultLength;
    }
 
}



class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}