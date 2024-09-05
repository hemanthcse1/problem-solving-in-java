package examples.interviewquestions.strings.easy;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterRemovingSubstrings solution = new MinimumStringLengthAfterRemovingSubstrings();


        System.out.println(solution.minLength("ABFCACDB"));
        System.out.println(solution.minLength("ACBDACBD"));
        System.out.println(solution.minLength("AABBCCDD"));
    }
}
