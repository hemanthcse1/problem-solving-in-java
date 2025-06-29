package examples.daily.june;

import java.util.Arrays;

public class SubsequenceSumChecker {

    public static void main(String[] args) {
        SubsequenceSumChecker solution = new SubsequenceSumChecker();

        int[] nums1 = {3, 5, 6, 7};
        int target1 = 9;
        System.out.println("Output 1: " + solution.numSubseq(nums1, target1)); //  4

        int[] nums2 = {3, 3, 6, 8};
        int target2 = 10;
        System.out.println("Output 2: " + solution.numSubseq(nums2, target2)); //  6

    }

    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
