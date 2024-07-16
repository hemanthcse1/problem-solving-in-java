package examples.interviewquestions.arrays;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        int[] suffixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i];
            int rightSum = suffixSum[i + 1];
            answer[i] = Math.abs(leftSum - rightSum);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 8, 3};
        int[] result = leftRightDifference(nums);

        System.out.println(Arrays.toString(result));
    }
}
