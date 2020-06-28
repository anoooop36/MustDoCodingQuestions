import java.util.*;
import java.io.*;


public class Converter {

    // supported operator *,/,+,-
    static boolean isOperator(char c){
        switch(c){
            case '*':
            case '/':
            case '+':
            case '-':
                return true;
            default:
                return false;
        }
    }
    /*
        Simple solution using one stack
            iterate from left
            operand -> push in stack
            operator -> pop two operands from stack create a expressin and push back to stack
        result will be in stack
    */
    static String postfixtToPrefix(String prefix, int n){
        Stack<String> st = new Stack<>();

        for(int i=0;i<n;i++){
            char currentChar = prefix.charAt(i);
            if (!isOperator(currentChar)) {
                st.add(currentChar+"");
            } else {
                String operand1 = st.pop();
                String operand2 = st.pop();
                String newExp = currentChar+operand2+operand1;
                st.push(newExp);
            }
        }
        return st.pop();
    }

    public static void main(String[] args){
        String expectedPrefix = "*+AB-CD";
        String postfix = "AB+CD-*";
        String actualPrefix = postfixtToPrefix(postfix, postfix.length());
        System.out.println(expectedPrefix.equals(actualPrefix));
        expectedPrefix = "*-A/BC-/AKL"; 
        postfix = "ABC/-AK/L-*";
        actualPrefix = postfixtToPrefix(postfix, postfix.length());
        System.out.println(expectedPrefix.equals(actualPrefix));
    }
}   