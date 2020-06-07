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
    // two loop solution: inner loop removes adjacent duplicates
    // outer loop runs till no duplicate removed.
    
    static String removeAllAdjacentDuplicates(String str){
            while(true){
                String temp = "";
                for(int i=0; i< str.length(); i++){
                    char c = str.charAt(i);
                    
                    // skip all adjacent duplicates
                    
                    while(i+1< str.length() && c == str.charAt(i+1)){
                        i++;
                    }
                    
                    // check current char is part of duplicates, if not doesnt need removal
                    
                    if(i > 0 && str.charAt(i) != str.charAt(i-1) || i == 0){
                        temp += str.charAt(i);
                    }
                }
                if(temp.length() == str.length()){
                    // no change after removal so break
                    break;
                } else {
                    str = temp;
                } 
            }
            return str;
        }

	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(removeAllAdjacentDuplicates(str)+"\n");
	    }
	    System.out.print(sb);
	 }
}