package examples.interviewquestions.stacks.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperaturesSolution {

    public static void main(String[] args) {
        DailyTemperaturesSolution solution = new DailyTemperaturesSolution();

        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1)));

        int[] temperatures2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2)));

        int[] temperatures3 = {30, 60, 90};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitDays = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousDay = stack.pop();
                waitDays[previousDay] = i - previousDay;
            }
            stack.push(i);
        }

        return waitDays;
    }
}
