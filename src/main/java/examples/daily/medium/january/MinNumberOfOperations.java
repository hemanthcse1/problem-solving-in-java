package examples.daily.medium.january;

import java.util.Arrays;

public class MinNumberOfOperations {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int[] leftCost = new int[n];
        int[] rightCost = new int[n];
        int count = boxes.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            leftCost[i] = leftCost[i - 1] + count;
            count += boxes.charAt(i) - '0';
        }
        count = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            rightCost[i] = rightCost[i + 1] + count;
            count += boxes.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            answer[i] = leftCost[i] + rightCost[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        MinNumberOfOperations sol = new MinNumberOfOperations();

        String boxes1 = "110";
        int[] result1 = sol.minOperations(boxes1);
        System.out.println("Input: " + boxes1);
        System.out.println("Output: " + Arrays.toString(result1));

        String boxes2 = "001011";
        int[] result2 = sol.minOperations(boxes2);
        System.out.println("Input: " + boxes2);
        System.out.println("Output: " + Arrays.toString(result2));
    }
}
