/*
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static boolean paranthesisCheck(String expr, int n){

        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            char c = expr.charAt(i);
            if(c==')' || c=='}' || c==']'){
                
                // not matching cases
                if(st.size() == 0 || st.peek() == '(' && c != ')' || st.peek() == '{' && c != '}' || st.peek() == '[' && c != ']')
                    return false;
                
                //matched remove top form stack
                st.pop();
                
            } else{
                st.push(c);
            }
        }
        
        return st.size() == 0;
    }
     
    
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    StringBuffer sb = new StringBuffer();
	    while(t-->0){
	        String expr = br.readLine();
	        if(paranthesisCheck(expr, expr.length())){
	            sb.append("balanced\n");
	        } else {
	            sb.append("not balanced\n");
	        }
	    }
	    System.out.print(sb);
	 }
}