/*
Given a string, the task is to remove duplicates from it. Expected time complexity O(n) where n is length of input 
string and extra space O(1) under the assumption that there are total 256 possible characters in a string.
https://practice.geeksforgeeks.org/problems/remove-duplicates/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     // since String is immutable we need to use result string (excluded then space is O(1))
     // otherwise take char array instead of string and store result in same array, O(1) space
     
	static String removeDuplicates(String str, int n){
	    
	    boolean vis[] = new boolean[256];
	    
	    Arrays.fill(vis, false);
	    StringBuffer sb = new StringBuffer();
	    
	    for(int i=0; i<n; i++){

	        char c = str.charAt(i);

	        if(vis[c]  == false){
	            vis[c] = true;
	            sb.append(c);
	        }
	    }
	    
	    return sb.toString();
	}
	
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(removeDuplicates(str,str.length())+"\n");
	    }
	    System.out.print(sb);
	 }
}