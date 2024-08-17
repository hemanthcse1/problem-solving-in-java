package examples.interviewquestions.arrays.easy;

public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i];
            }
        }
        maxSum = Math.max(maxSum, currentSum);
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumAscendingSubarraySum solver = new MaximumAscendingSubarraySum();

        int[] nums1 = {10, 20, 30, 5, 10, 50};
        System.out.println(solver.maxAscendingSum(nums1));
    }
}
