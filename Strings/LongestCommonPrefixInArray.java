/*
Given a array of N strings, find the longest common prefix among all strings present in the array.
https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG
 {
    // gets common prefix of two strings
    static String commonPrefixTwoStrings(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int minLength = Math.min(n,m);
        
        for(int i=0;i<n;i++){
            if(str1.charAt(i) != str2.charAt(i)){
                if(i==0)
                    return "";
                return str1.substring(0, i);
            }
        }
        return str1.substring(0,minLength);
    }
    
    // O(minLength * N)
    static String getCommonPrefix(String[] strs, int n){
        
        String smallestStringPrefix = strs[0];
        
        // get min from all string lengths
        for(int i=1;i<n;i++){
            if(smallestStringPrefix.length() > strs[i].length()){
                smallestStringPrefix = strs[i];
            }
        }
        
        // update smallest string prefix if smaller prefix found by comparing each of the other strings
        for(int i=0;i<n;i++){
            if(smallestStringPrefix.length() > 0){
                smallestStringPrefix = commonPrefixTwoStrings(smallestStringPrefix, strs[i]);
            } else {
                return "-1";
            }
        }
        
        return smallestStringPrefix.length() > 0 ? smallestStringPrefix : "-1";
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
	        sb.append(getCommonPrefix(strs,n)+"\n");
	    }
	    System.out.print(sb);
	 }
}