package examples.interviewquestions.strings.medium;

import java.util.Stack;

public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;
        int num = 0;
        boolean negative = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-') {
                negative = true;
            } else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                if (current != null) {
                    stack.push(current);
                }
                current = new NestedInteger();
            } else if (ch == ',' || ch == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative) {
                        num = -num;
                    }
                    current.add(new NestedInteger(num));
                }
                num = 0;
                negative = false;

                if (ch == ']' && !stack.isEmpty()) {
                    NestedInteger top = stack.pop();
                    top.add(current);
                    current = top;
                }
            }
        }

        return current;
    }

    public static void main(String[] args) {
        MiniParser parser = new MiniParser();

        String s1 = "324";
        NestedInteger result1 = parser.deserialize(s1);
        System.out.println(result1.getInteger());

        String s2 = "[123,[456,[789]]]";
        NestedInteger result2 = parser.deserialize(s2);
        System.out.println(result2);
    }
}
