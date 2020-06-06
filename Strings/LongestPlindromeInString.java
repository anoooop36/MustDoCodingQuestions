/*
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. 
Incase of conflict, return the substring which occurs first ( with the least starting index ).
https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0
*/


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG
 {
     /*
     Decision for smaller strings can be used to make decisions for bigger strings.
     Start computing plindrome for smallest to largest. for str[i...j] if str[i] == str[j] then its inner substring
     str[i+1..j-1] must be plindrome inorder to str[i..j] be plindrome.
     */
    static String getLongestPlindrome(String str, int n){
        boolean dp[][] = new boolean[n][n];
        int largestPlindromeIndex = 0;
        int largestPlindromeLength = 1;
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], false);
        }
        
        // length 1 string is plindrome
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        
        // length 2 string is plindrome if str.charAt(i) == str.charAt(i+1)
        for(int i=0;i<n-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                if(largestPlindromeLength<2){
                    largestPlindromeLength = 2;
                    largestPlindromeIndex = i;
                }
            }
        }
        
        // legth >2 string str[i..j] is plindrome if str[i] == str[j] && str[i+1..j-1] is plindrome
        for(int l=3;l<=n;l++){
            for(int i=0; i<=n-l; i++){
                int j = i+l-1;
                if(str.charAt(i) == str.charAt(j)){
                    if(dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        if(largestPlindromeLength < l){
                            largestPlindromeLength = l;
                            largestPlindromeIndex = i;
                        }
                    }
                }
            }
        }
        return str.substring(largestPlindromeIndex, largestPlindromeIndex+largestPlindromeLength);
    } 
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(getLongestPlindrome(str,str.length())+"\n");
	    }
	    System.out.print(sb);
	 }
}