package examples.daily.june;

import java.util.Arrays;

public class MinimizeMaxPairDifference {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; ) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= p;
    }

    public static void main(String[] args) {
        MinimizeMaxPairDifference solver = new MinimizeMaxPairDifference();
        int[] nums1 = {10, 1, 2, 7, 1, 3};
        int p1 = 2;
        System.out.println(solver.minimizeMax(nums1, p1)); // Output: 1

        int[] nums2 = {4, 2, 1, 2};
        int p2 = 1;
        System.out.println(solver.minimizeMax(nums2, p2)); // Output: 0
    }
}
