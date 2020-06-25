/*
Given an infix expression in the form of a string str. Conver this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
https://practice.geeksforgeeks.org/problems/infix-to-postfix/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    // ^,*,/,+,-.
    static int precedence(char c) {
        if (c == '^')
            return 5;
        if (c == '*' || c == '/')
            return 4;
        else if (c == '-' || c == '+')
            return 3;
        else
            return 0;
    }

    static boolean isOperator(char c) {
        int asci1 = c - 'a';
        int asci2 = c - 'A';
        if (0 <= asci1 && asci1 < 26 || 0 <= asci2 && asci2 < 26) {
            return false;
        }
        return true;
    }

    /*
     * Solved using Single stack and auxilary postfix string. if operand add to
     * postfix else if operator handle '(' and ')' separately
     * 
     * '(' has lowest precedence among all operators
     */
    static String infixToPostfix(String exp, int n) {
        Stack<Character> st = new Stack<>();
        StringBuffer postFix = new StringBuffer();

        for (int i = 0; i < n; i++) {
            char current = exp.charAt(i);
            if (!isOperator(current)) {
                postFix.append(current);
            } else {
                if (current == ')') {
                    while (st.size() > 0 && st.peek() != '(') {
                        postFix.append(st.peek());
                        st.pop();
                    }
                    st.pop();
                } else if (current == '(') {
                    st.push(current);
                } else {
                    while (st.size() > 0 && precedence(st.peek()) >= precedence(current)) {
                        postFix.append(st.peek());
                        st.pop();
                    }
                    st.push(current);
                }
            }
        }
        while (st.size() > 0) {
            postFix.append(st.peek());
            st.pop();
        }
        return postFix.toString();
    }

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            sb.append(infixToPostfix(str, str.length()) + "\n");
        }
        System.out.print(sb);
    }
}