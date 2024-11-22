package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class MaximumXORForEachQuery {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int xorTotal = 0;
        for (int num : nums) {
            xorTotal ^= num;
        }

        int maxVal = (1 << maximumBit) - 1;

        for (int i = 0; i < n; i++) {
            result[i] = xorTotal ^ maxVal;
            xorTotal ^= nums[n - 1 - i];
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumXORForEachQuery solution = new MaximumXORForEachQuery();

        int[] nums1 = {0, 1, 1, 3};
        int maximumBit1 = 2;
        System.out.println("Test Case 1 Output: " + Arrays.toString(solution.getMaximumXor(nums1, maximumBit1)));

        int[] nums2 = {2, 3, 4, 7};
        int maximumBit2 = 3;
        System.out.println("Test Case 2 Output: " + Arrays.toString(solution.getMaximumXor(nums2, maximumBit2)));


    }
}
