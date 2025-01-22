package examples.interviewquestions.stacks.hard;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result += sign * num;

            } else if (c == '+') {
                sign = 1;


            } else if (c == '-') {
                sign = -1;


            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;

            } else if (c == ')') {
                int oldSign = stack.pop();
                int oldRes = stack.pop();
                result = oldRes + oldSign * result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));

        System.out.println(calculate("-1+2"));
    }
}
