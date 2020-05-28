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
	static void getIndexOfBuySell(Stack<Integer> st, StringBuffer sb){
	    if(st.size()>1){
	        int lastIndex = st.peek();
	        while(st.size() > 1){
	            st.pop();
	        }
	        int firstIndex = st.peek();
	        st.pop();
	        sb.append("("+firstIndex+" "+lastIndex+") ");
	    }
	}
	
	/*
	    if current price is smaller than prev definitely sell on prev and buy at current
	    5 4 8      since 5 > 4 buy at four rather than five
	    5 6 8      sell at last highest of increasing sequence
	    
	*/
	static StringBuffer getAllPairOfDaysOfBuySell(int arr[], int n){
	    Stack<Integer> st = new Stack<>();
	    StringBuffer sb = new StringBuffer();
	    for(int i=0;i<n;i++){
	        if(st.size() == 1){
				// new smaller found and stack has one, can't form pair, remove it
	            if(arr[i] < arr[st.peek()]){
	                st.pop();
	            }
	        } else if(st.size()>=2){
				// important case it will cause to remove all (increasing sequence) elements from stack and get a pair for it 
	            if(arr[i] < arr[st.peek()]){
	                getIndexOfBuySell(st,sb);
	            }
	        }
			// always push current
	        st.push(i);
	    }
		// stack may contain last increasing sequence which can form a pair
	    getIndexOfBuySell(st,sb);
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