package examples.daily;

import java.util.Arrays;

public class TargetSumSolution {

    public static void main(String[] args) {
        TargetSumSolution solution = new TargetSumSolution();

        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println(solution.findTargetSumWays(nums1, target1));

        int[] nums2 = {1};
        int target2 = 1;
        System.out.println(solution.findTargetSumWays(nums2, target2));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int offset = 1000;
        int[][] memo = new int[n][2001];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums, target, 0, 0, memo, offset);
    }

    private int dfs(int[] nums, int target, int index, int currentSum, int[][] memo, int offset) {
        if(index == nums.length) {
            return currentSum == target ? 1 : 0;
        }
        if(currentSum + offset > 2000 || currentSum + offset < 0) {
            return 0;
        }
        if(memo[index][currentSum + offset] != Integer.MIN_VALUE) {
            return memo[index][currentSum + offset];
        }
        int add = dfs(nums, target, index + 1, currentSum + nums[index], memo, offset);
        int subtract = dfs(nums, target, index + 1, currentSum - nums[index], memo, offset);
        memo[index][currentSum + offset] = add + subtract;
        return memo[index][currentSum + offset];
    }
}
