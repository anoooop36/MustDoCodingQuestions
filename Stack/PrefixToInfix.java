import java.util.*;
import java.io.*;


class Converter {

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
    static String prefixToInfix(String prefix, int n){
        Stack<String> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            char currentChar = prefix.charAt(i);
            if (!isOperator(currentChar)) {
                st.add(currentChar+"");
            } else {
                String operand1 = st.pop();
                String operand2 = st.pop();
                String newExp = "("+operand1+currentChar+operand2+")";
                st.push(newExp);
            }
        }
        return st.pop();
    }

    public static void main(String[] args){
        String prefix = "*+AB-CD";
        String expectedInfix = "((A+B)*(C-D))";
        String actualInfix = prefixToInfix(prefix, prefix.length());
        System.out.println(expectedInfix.equals(actualInfix));
        prefix = "*-A/BC-/AKL"; 
        actualInfix = prefixToInfix(prefix, prefix.length());
        expectedInfix = "((A-(B/C))*((A/K)-L))";
        System.out.println(expectedInfix.equals(actualInfix));
    }
}   