package examples.interviewquestions.stacks;

import java.util.Stack;

public class InfixToPostfix {

    public static String convertToPostfix(String infix) {
        if (infix == null || infix.isEmpty()) {
            return "";
        }

        java.util.Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c); // Append operands directly
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove the '(' from the stack
            } else { // Operator
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0; // Not an operator
        }
    }

    public static void main(String[] args) {
        String infix = "a + b * c - d ^ e";
        String postfix = convertToPostfix(infix);

        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression");
    }
}