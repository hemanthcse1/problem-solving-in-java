package examples.daily.april;

import java.util.Arrays;

public class FairPairCounter {

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
        FairPairCounter counter = new FairPairCounter();
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3, upper = 6;
        long result = counter.countFairPairs(nums, lower, upper);
        System.out.println("Number of fair pairs: " + result);
    }
}
