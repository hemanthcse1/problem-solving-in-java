package examples.interviewquestions.strings.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ReverseSubstringsBetweenParentheses {

    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                List<Character> temp = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop();
                for (char ch : temp) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenParentheses solution = new ReverseSubstringsBetweenParentheses();

        System.out.println(solution.reverseParentheses("(abcd)"));
        System.out.println(solution.reverseParentheses("(u(love)i)"));
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
    }
}
