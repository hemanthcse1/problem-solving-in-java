package examples.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxSumOfDistinctSubarrays {

    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        long maxSum = 0, currentSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);
            currentSum += nums[end];

            while (end - start + 1 > k) {
                frequencyMap.put(nums[start], frequencyMap.get(nums[start]) - 1);
                if (frequencyMap.get(nums[start]) == 0) {
                    frequencyMap.remove(nums[start]);
                }
                currentSum -= nums[start];
                start++;
            }

            if (end - start + 1 == k && frequencyMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        System.out.println(maximumSubarraySum(nums1, k1));

        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        System.out.println(maximumSubarraySum(nums2, k2));

        int[] nums3 = {1, 1, 1, 7, 8, 9};
        int k3 = 3;
        System.out.println(maximumSubarraySum(nums3, k3));
    }
}
