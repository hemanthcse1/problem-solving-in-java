package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers solution = new MaximumProductOfThreeNumbers();

        int[] nums1 = {1, 2, 3};
        System.out.println("Test case 1 output: " + solution.maximumProduct(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test case 2 output: " + solution.maximumProduct(nums2));

        int[] nums3 = {-1, -2, -3};
        System.out.println("Test case 3 output: " + solution.maximumProduct(nums3));
    }
}
