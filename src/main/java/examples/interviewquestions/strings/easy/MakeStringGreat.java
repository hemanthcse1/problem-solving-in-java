package examples.interviewquestions.strings.easy;

import java.util.Stack;

public class MakeStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MakeStringGreat solution = new MakeStringGreat();

        System.out.println(solution.makeGood("leEeetcode"));
        System.out.println(solution.makeGood("abBAcC"));
        System.out.println(solution.makeGood("s"));
    }
}
