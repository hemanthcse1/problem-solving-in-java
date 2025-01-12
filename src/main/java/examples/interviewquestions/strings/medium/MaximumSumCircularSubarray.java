package examples.interviewquestions.strings.medium;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            totalSum += num;

            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray solver = new MaximumSumCircularSubarray();

        int[] nums1 = {1, -2, 3, -2};
        System.out.println(solver.maxSubarraySumCircular(nums1));

        int[] nums2 = {5, -3, 5};
        System.out.println(solver.maxSubarraySumCircular(nums2));

        int[] nums3 = {-3, -2, -3};
        System.out.println(solver.maxSubarraySumCircular(nums3));
    }
}
