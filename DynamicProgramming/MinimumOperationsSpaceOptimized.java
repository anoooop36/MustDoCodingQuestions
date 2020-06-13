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
     // f(n) = 1 + f(n/2) if n is even else f(n) = 1 + f(n-1) 
     // start from n and reach to 0
	 static int getMinOperations(int n){
	     
	     int operations = 0;
	     
	     while(n > 0){
	         
	         if(n % 2 == 1){
	             n--;
	         } else {
	             n /= 2;
	         }
	         operations++;
	     }
	     
	     return operations;
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