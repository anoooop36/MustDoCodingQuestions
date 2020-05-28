/*
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the 
stock so that in between those days your profit is maximum.
https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {

	/*
	    
	    if current price is smaller than prev definitely sell on prev and buy at current
	    5 4 8      since 5 > 4 buy at four rather than five
	    5 6 8      sell at last highest of increasing sequence
	    O(n) time and O(1) space
	    
	    every increasing contiguous sequence of size greater than 2 is part of solution.
	*/
	static StringBuffer getAllPairOfDaysOfBuySell(int arr[], int n){
	    StringBuffer sb = new StringBuffer();
	    for(int i=0;i<n;i++){
	        int j = i+1;
	        //continuous increasing sequence is part of solution
	        while(j<n && arr[j-1] < arr[j]){
	            j++;
	        }
	        j--;
	        if(i!=j){
	            sb.append("("+i+" "+j+") ");
	        }
	        i = j;
	    }
	    return sb;
	}
	
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        StringBuffer resultPairs = getAllPairOfDaysOfBuySell(arr,n);
	        if(resultPairs.length()>0)
	            sb.append(resultPairs+"\n");
	        else
	            sb.append("No Profit\n");
	    }
	    System.out.print(sb);
	 }
}