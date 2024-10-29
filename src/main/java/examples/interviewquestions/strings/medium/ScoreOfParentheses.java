package examples.interviewquestions.strings.medium;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();
                int outerScore = stack.pop();
                int newScore = outerScore + Math.max(2 * innerScore, 1);
                stack.push(newScore);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        ScoreOfParentheses solution = new ScoreOfParentheses();


        String s1 = "()";
        System.out.println("Score for \"()\": " + solution.scoreOfParentheses(s1));

        String s2 = "(())";
        System.out.println("Score for \"(())\": " + solution.scoreOfParentheses(s2));

        String s4 = "(()(()))";
        System.out.println("Score for \"(()(()))\": " + solution.scoreOfParentheses(s4));
    }
}
