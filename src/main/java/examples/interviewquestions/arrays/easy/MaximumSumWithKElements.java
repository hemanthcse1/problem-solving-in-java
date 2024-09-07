package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class MaximumSumWithKElements {
    public static int maximizeSum(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += maxElement;
            maxElement++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        int result = maximizeSum(nums, k);
        System.out.println("Maximum sum with exactly " + k + " elements: " + result);
    }
}
