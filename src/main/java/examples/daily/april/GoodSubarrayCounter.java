package examples.daily.april;

import java.util.HashMap;
import java.util.Map;

public class GoodSubarrayCounter {

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long count = 0, pairs = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            pairs += freq.getOrDefault(val, 0);
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            while (pairs >= k) {
                count += nums.length - right;
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                pairs -= freq.get(leftVal);
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GoodSubarrayCounter counter = new GoodSubarrayCounter();

        int[] nums1 = {1, 1, 1, 1, 1};
        int k1 = 10;
        System.out.println("Output 1: " + counter.countGood(nums1, k1)); //  1

        int[] nums2 = {3, 1, 4, 3, 2, 2, 4};
        int k2 = 2;
        System.out.println("Output 2: " + counter.countGood(nums2, k2)); //  4
    }
}
