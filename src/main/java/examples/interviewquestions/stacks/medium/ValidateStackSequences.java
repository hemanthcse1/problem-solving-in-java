package examples.interviewquestions.stacks.medium;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validator = new ValidateStackSequences();

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        boolean result = validator.validateStackSequences(pushed, popped);
        System.out.println(result);
    }
}
