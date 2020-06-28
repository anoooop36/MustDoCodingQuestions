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
            iterate from right
            operand -> push in stack
            operator -> pop two operands from stack create a expressin and push back to stack
        result will be in stack
    */
    static String prefixToPostfix(String prefix, int n){
        Stack<String> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            char currentChar = prefix.charAt(i);
            if (!isOperator(currentChar)) {
                st.add(currentChar+"");
            } else {
                String operand1 = st.pop();
                String operand2 = st.pop();
                String newExp = operand1+operand2+currentChar;
                st.push(newExp);
            }
        }
        return st.pop();
    }

    public static void main(String[] args){
        String prefix = "*+AB-CD";
        String expectedPostfix = "AB+CD-*";
        String actualPostfix = prefixToPostfix(prefix, prefix.length());
        System.out.println(expectedPostfix.equals(actualPostfix));
        prefix = "*-A/BC-/AKL"; 
        actualPostfix = prefixToPostfix(prefix, prefix.length());
        expectedPostfix = "ABC/-AK/L-*";
        System.out.println(expectedPostfix.equals(actualPostfix));
    }
}   