package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class MaxProductDifference {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int max1 = nums[n - 1];
        int max2 = nums[n - 2];
        int min1 = nums[0];
        int min2 = nums[1];

        return (max1 * max2) - (min1 * min2);
    }

    public static void main(String[] args) {
        MaxProductDifference solution = new MaxProductDifference();

        int[] nums1 = {5, 6, 2, 7, 4};
        System.out.println(solution.maxProductDifference(nums1));

        int[] nums2 = {4, 2, 5, 9, 7, 4, 8};
        System.out.println(solution.maxProductDifference(nums2));
    }
}
