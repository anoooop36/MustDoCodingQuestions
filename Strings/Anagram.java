/*
Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are anagram 
of each other or not. An anagram of a string is another string that contains same characters, only the order of characters
can be different. For example, “act” and “tac” are anagram of each other.
https://practice.geeksforgeeks.org/problems/anagram/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	 static boolean isAnagram(String str1, String str2){
	     int n = str1.length();
	     int m = str2.length();
	     
	     if(m != n)
	        return false;
	       
	     int freqA[] = new int[26];
	     int freqB[] = new int[26];
	     
	     Arrays.fill(freqA,0);
	     Arrays.fill(freqB,0);
	     
	     for(int i=0; i<n; i++){
	         freqA[str1.charAt(i)-'a']++;
	         freqB[str2.charAt(i)-'a']++;
	     }
	     
	     for(int i=0;i<26;i++){
	         if(freqA[i] != freqB[i])
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
	        String strs[] = br.readLine().split(" ");
	        if(isAnagram(strs[0], strs[1]))
	            sb.append("YES\n");
	        else
	            sb.append("NO\n");
	    }
	    System.out.print(sb);
	 }
}