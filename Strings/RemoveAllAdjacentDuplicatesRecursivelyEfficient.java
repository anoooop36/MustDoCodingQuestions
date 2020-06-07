/*
Given a string s, recursively remove adjacent duplicate characters from the string s. 
The output string should not have any adjacent duplicates.
ex: mississipie => mpie
https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    // O(n) time and O(n) space (if string buffer used)
    // Remove all duplicates from left of string and maitain last removed
    // recursively remove all duplicates on right of 0th index and maintain last removed => rightString
    // if 0th index char matches with rightString's 0th char then its a duplicate and solution is rightString.substring(1,length) 
    // otherwise compare lastRemoved char to 0th char of str and decide to add or remove 0th char of str in result update last removed
    
    static char lastRemoved = '\0';
    
    static String removeAllAdjacentDuplicates(String str, int n){
        if(n==0 || n==1){
            return str.substring(0);
        } else {
            
            if(str.charAt(0) == str.charAt(1)){
                while(str.length() > 1 && str.charAt(0) == str.charAt(1)){
                    lastRemoved = str.charAt(0);
                    str  = str.substring(1);
                }
                str = str.substring(1);
                return removeAllAdjacentDuplicates(str,str.length());
            }
            
            String rem_str = str.substring(1);
            String right = removeAllAdjacentDuplicates(rem_str, rem_str.length());
            
            if(right.length() > 0 && right.charAt(0) == str.charAt(0)){
                lastRemoved = right.charAt(0);
                return right.substring(1);
            }
            
            if(str.length() > 0 && lastRemoved == str.charAt(0))
                return right;
                
            if(n == str.length()){
                lastRemoved = '\0';
            }
            
            return str.charAt(0)+right;
        }
    }

	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(removeAllAdjacentDuplicates(str,str.length())+"\n");
	    }
	    System.out.print(sb);
	 }
}