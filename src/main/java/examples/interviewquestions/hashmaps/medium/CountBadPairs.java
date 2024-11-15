package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class CountBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long goodPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            goodPairs += freqMap.getOrDefault(key, 0);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }

    public static void main(String[] args) {
        CountBadPairs solution = new CountBadPairs();

        int[] nums1 = {4, 1, 3, 3};
        System.out.println(solution.countBadPairs(nums1));

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(solution.countBadPairs(nums2));
    }
}
