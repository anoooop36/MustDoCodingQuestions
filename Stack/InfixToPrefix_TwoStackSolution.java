import java.util.*;
import java.io.*;

public class InfixToPrefix_TwoStackSolution {

    static boolean isOperand(char ch) {
        if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
            return true;
        }
        return false;
    }

    static int precedence(char ch) {
        if (ch == '(')
            return 0;
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '^')
            return 3;
        return -1;
    }

    /*
     * Scan from left 
     * if operand push to expressionStack 
     * if char is '(' push to  operatorStack 
     * else if char is ')' then pop a oprator and pop two expressions and create new prefix expression and push to expression stack while '(' found
     * dont add '(' to expression but remove from stack
     * else if stack empty || precedence(stack.peek()) < precedence(op) push operator 
     * else while operator stack is not empty and precedence(stack.peek()) < precedence(op) then pop and
     * create prefix expression and push back to expression stack
     * 
     * while operator stack is not empty pop and create prefix expression and push
     * back to expression stack
     */
    static String infixToPrefix(String infix, int n) {

        Stack<String> expressionStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isOperand(ch)) {
                expressionStack.push(ch + "");
            } else {
                if (ch == '(') {
                    operatorStack.push(ch);
                } else if (ch == ')') {
                    while (operatorStack.size() > 0 && operatorStack.peek() != '(') {
                        String exp2 = expressionStack.pop();
                        String exp1 = expressionStack.pop();
                        char operator = operatorStack.pop();
                        expressionStack.push(operator + exp1 + exp2);
                    }
                    operatorStack.pop();
                } else {
                    while (operatorStack.size() > 0 && precedence(ch) <= precedence(operatorStack.peek())) {
                        String exp2 = expressionStack.pop();
                        String exp1 = expressionStack.pop();
                        char operator = operatorStack.pop();
                        expressionStack.push(operator + exp1 + exp2);
                    }
                    operatorStack.push(ch);
                }
            }
        }

        while (operatorStack.size() > 0) {
            String exp2 = expressionStack.pop();
            String exp1 = expressionStack.pop();
            char operator = operatorStack.pop();
            expressionStack.push(operator + exp1 + exp2);
        }

        return expressionStack.pop();
    }

    public static void main(String[] args) {
        String expectedPrefix = "*+AB-CD";
        String infix = "((A+B)*(C-D))";
        String actualPrefix = infixToPrefix(infix, infix.length());
        System.out.println(expectedPrefix.equals(actualPrefix));
        infix = "((A-(B/C))*((A/K)-L))";
        expectedPrefix = "*-A/BC-/AKL";
        actualPrefix = infixToPrefix(infix, infix.length());
        System.out.println(expectedPrefix.equals(actualPrefix));
    }
}