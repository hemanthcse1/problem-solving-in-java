package examples.daily.february;

import java.util.Stack;

public class SmallestNumberDI {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SmallestNumberDI solver = new SmallestNumberDI();
        System.out.println(solver.smallestNumber("IIIDIDDD")); //  "123549876"
        System.out.println(solver.smallestNumber("DDD"));       //  "4321"
    }
}
