/*
Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing,
the missing number is to be found.
https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        String strs[] = br.readLine().split(" ");
	        long sum = 0;
	        for(int i=0;i<n-1;i++){
	            sum += Integer.parseInt(strs[i]);
	        }
	        // Missing number = n*(n+1)/2 - sum
	        sb.append((n*(n+1))/2-sum+"\n");
	    }
	    System.out.print(sb);
	 }
}