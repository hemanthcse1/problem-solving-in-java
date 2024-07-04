package examples.interviewquestions.stacks;

import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String str) {
        if (str == null || str.isEmpty()) {
            return true; // Empty string is considered balanced
        }

        java.util.Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (isOpenParen(c)) {
                stack.push(c);
            } else if (isClosedParen(c)) {
                if (stack.isEmpty() || !isMatchingParen(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // All opening parentheses must have a closing pair
    }

    private static boolean isOpenParen(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    private static boolean isClosedParen(char c) {
        return c == '}' || c == ']' || c == ')';
    }

    private static boolean isMatchingParen(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String str1 = "{[()]}";
        String str2 = "{[()]}})";

        System.out.println(str1 + " is balanced: " + isBalanced(str1));
        System.out.println(str2 + " is balanced: " + isBalanced(str2));
    }
}
