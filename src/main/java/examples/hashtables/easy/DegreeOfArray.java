package examples.hashtables.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> firstOccurrenceMap = new HashMap<>();
        Map<Integer, Integer> lastOccurrenceMap = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (!firstOccurrenceMap.containsKey(num)) {
                firstOccurrenceMap.put(num, i);
            }
            lastOccurrenceMap.put(num, i);

            degree = Math.max(degree, countMap.get(num));
        }

        int minLength = nums.length;

        for (int num : countMap.keySet()) {
            if (countMap.get(num) == degree) {
                int length = lastOccurrenceMap.get(num) - firstOccurrenceMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        DegreeOfArray solution = new DegreeOfArray();

        int[] nums1 = {1, 2, 2, 3, 1};
        System.out.println("Shortest subarray length: " + solution.findShortestSubArray(nums1)); // Output: 2

        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println("Shortest subarray length: " + solution.findShortestSubArray(nums2)); // Output: 6
    }
}
