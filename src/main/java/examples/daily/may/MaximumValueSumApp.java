package examples.daily.may;

public class MaximumValueSumApp {

    public static void main(String[] args) {
        MaximumValueSumApp solution = new MaximumValueSumApp();

        int[] nums1 = {1, 2, 3};
        int k1 = 1;
        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println("Maximum Value Sum: " + solution.maximumValueSum(nums1, k1, edges1)); // Expected: 7

        int[] nums2 = {2, 4, 6, 8};
        int k2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Maximum Value Sum: " + solution.maximumValueSum(nums2, k2, edges2)); // Expected depends on logic
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int countBetterWithXor = 0;
        int minDifference = Integer.MAX_VALUE;

        for (int num : nums) {
            int original = num;
            int xorWithK = num ^ k;

            if (xorWithK > original) {
                totalSum += xorWithK;
                countBetterWithXor++;
            } else {
                totalSum += original;
            }

            minDifference = Math.min(minDifference, Math.abs(original - xorWithK));
        }

        if (countBetterWithXor % 2 == 0) {
            return totalSum;
        }

        return totalSum - minDifference;
    }
}
