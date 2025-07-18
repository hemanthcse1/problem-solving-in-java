package examples.daily.july;

import java.util.Arrays;

public class ValidSubsequenceFinder {

    private int[][] memo;

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        memo = new int[n][k];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        int maxLen = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int mod = (nums[i] + nums[j]) % k;
                maxLen = Math.max(maxLen, 2 + dfs(nums, j, mod, k));
            }
        }

        return maxLen;
    }

    private int dfs(int[] nums, int index, int mod, int k) {
        if (memo[index][mod] != -1)
            return memo[index][mod];

        int maxLen = 0;
        for (int next = index + 1; next < nums.length; ++next) {
            if ((nums[index] + nums[next]) % k == mod) {
                maxLen = Math.max(maxLen, 1 + dfs(nums, next, mod, k));
            }
        }

        return memo[index][mod] = maxLen;
    }

    public static void main(String[] args) {
        ValidSubsequenceFinder finder = new ValidSubsequenceFinder();

        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Output 1: " + finder.maximumLength(nums1, k1)); // Expected: 5

        int[] nums2 = {1, 4, 2, 3, 1, 4};
        int k2 = 3;
        System.out.println("Output 2: " + finder.maximumLength(nums2, k2)); // Expected: 4
    }
}
