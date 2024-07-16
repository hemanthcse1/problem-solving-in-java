package examples.interviewquestions.arrays;

import java.util.Arrays;

public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxSum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        ArrayPartition solution = new ArrayPartition();

        int[] nums1 = {1, 4, 3, 2};
        System.out.println(solution.arrayPairSum(nums1));

        int[] nums2 = {6, 2, 6, 5, 1, 2};
        System.out.println(solution.arrayPairSum(nums2));
    }
}
