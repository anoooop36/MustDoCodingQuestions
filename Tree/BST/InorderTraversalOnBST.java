/*
Given an array, write a program that prints 1 if array represents Inorder traversal of a BST, else prints 0. 
Note that all keys in BST must be unique.
https://practice.geeksforgeeks.org/problems/inorder-traversal-and-bst/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     /*
        BST's inorder will be in sorted order
     */
     static boolean isValidBst(int in[], int n){
         for(int i=1;i<n;i++){
             if(in[i]<=in[i-1])
                return false;
         }
         return true;
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
	        if(isValidBst(arr,n) == true)
	            sb.append(1+"\n");
	        else
	            sb.append(0+"\n");
	    }
	    System.out.print(sb);
	 }
}