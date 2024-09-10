package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class MinOperationsToExceedThreshold {
    public static int minOperationsToExceedThreshold(int[] nums, int k) {

        Arrays.sort(nums);

        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                operations++;
            } else {
                break;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2, 7, 9};
        int k = 4;
        System.out.println("Minimum operations: " + minOperationsToExceedThreshold(nums, k));
    }
}
