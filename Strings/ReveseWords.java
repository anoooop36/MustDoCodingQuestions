/*
Given a String of length S, reverse the whole string without reversing the individual words in it. 
Words are separated by dots.
https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     // iterate from right maitain temp string by appending char at begning until . found
     // if . found append temp to result string 
     // O(n) space complexity, O(n2) time complexity (each concatenation has O(n) complexity)
    static String reverseWordsInString(String str){
        StringBuffer result = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i) == '.'){
                temp.append(".");
                result.append(temp);
                temp = new StringBuffer();
            } else {
                // temp = char + temp revese append
                temp.insert(0,str.charAt(i));
            }
        }
        result.append(temp);
        return result.toString();
    }
     
	public static void main (String[] args) throws IOException
	 {
	 //code
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String str = br.readLine();
	        sb.append(reverseWordsInString(str)+"\n");
	    }
	    System.out.print(sb);
	 }
}