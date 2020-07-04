/*
Evaluate an expression represented by a String. 
Expression can contain parentheses, you can assume parentheses are well-matched. For simplicity, 
you can assume only binary operations allowed are +, -, *, and /.
*/

import java.util.Stack;

public class ExpressionEvaluation {

    static int evaluate(char op, int operand2, int operand1) {
        switch (op) {
            case '+': return operand1 + operand2;
            case '*': return operand1 * operand2;
            case '/': return operand1 / operand2;
            case '-': return operand1 - operand2;
            default: return -1;
        }
    }

    static int precedence(char ch){
        switch (ch) {
            case '(': return 0;
            case '+': return 1;
            case '-': return 1;
            case '/': return 2;
            case '*': return 2;
            default: return -1;
        }
    }

    /*
        Based on operator precedence evalute expression. 
        higher precendence operator must be evaluated first.
        Use modified infix to postfix conversion for evaluation
        Use two stacks one for operator and one for expression value 
    */
    static int evaluateExpression(String expression, int n){
        Stack<Integer> expressionStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch>= '0' && ch <= '9') {
                StringBuffer sb = new StringBuffer();
                while (i<n && ch>= '0' && ch <= '9') {
                    sb.append(ch);
                    i++;
                    if (i<n) {
                        ch = expression.charAt(i);   
                    }
                }
                expressionStack.push(Integer.parseInt(sb.toString()));
                i--;
            }
            else if(ch == '('){
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.size() > 0 && operatorStack.peek() != '(') {
                    expressionStack.push(evaluate(operatorStack.pop(),expressionStack.pop(),expressionStack.pop()));
                }
                operatorStack.pop();
            } else {
                while (operatorStack.size() > 0 && precedence(operatorStack.peek()) >= precedence(ch) ) {
                    expressionStack.push(evaluate(operatorStack.pop(),expressionStack.pop(),expressionStack.pop()));
                }
                operatorStack.push(ch);
            }
        }

        while (operatorStack.size() > 0) {
            expressionStack.push(evaluate(operatorStack.pop(),expressionStack.pop(),expressionStack.pop()));
        }

        return expressionStack.pop();
    }

    public static void main(String[] args) {
        String expression = "2*(6/3)+(8-3)";
        System.out.println(evaluateExpression(expression, expression.length()) == 9);
        expression = "((3*2)+(3-4))+((10/5)*3)";
        System.out.println(evaluateExpression(expression, expression.length()) == 11);
    }
}