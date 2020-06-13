/*
You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:
Double the number
Add one to the number
https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     // f(n) = 1 + Min(f(n-1), f(n/2)) if n is even else f(n) = 1 + f(n-1) 
     
	 static int getMinOperations(int n){
	     
	     int operations[] = new int[n+1];
	     operations[0] = 0;
	     
	     for(int i=1;i<=n;i++){
	         if(i%2 == 0){
	             operations[i] = 1 + Math.min(operations[i-1], operations[i/2]);
	         } else {
	             operations[i] = 1 + operations[i-1];
	         }
	     }
	     
	     return operations[n];
	 }
	 
	 
	 public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        sb.append(getMinOperations(n)+"\n");
	    }
	    System.out.print(sb);
	 }
}