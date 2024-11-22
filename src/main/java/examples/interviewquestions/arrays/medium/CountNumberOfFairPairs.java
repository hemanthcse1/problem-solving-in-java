package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class CountNumberOfFairPairs {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = lowerBound(nums, i + 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, upper - nums[i]);
            count += (right - left);
        }

        return count;
    }

    private int lowerBound(int[] nums, int start, int target) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int upperBound(int[] nums, int start, int target) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        CountNumberOfFairPairs solution = new CountNumberOfFairPairs();

        int[] nums1 = {0, 1, 7, 4, 4, 5};
        int lower1 = 3, upper1 = 6;
        System.out.println(solution.countFairPairs(nums1, lower1, upper1));

        int[] nums2 = {1, 7, 9, 2, 5};
        int lower2 = 11, upper2 = 11;
        System.out.println(solution.countFairPairs(nums2, lower2, upper2));

    }
}
