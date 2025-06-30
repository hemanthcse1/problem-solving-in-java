package examples.daily.june;

import java.util.HashMap;
import java.util.Map;

public class HarmoniousSubsequenceMain {
    public static void main(String[] args) {
        HarmoniousSubsequenceMain solution = new HarmoniousSubsequenceMain();

        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println("Output 1: " + solution.findLHS(nums1)); //  5

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Output 2: " + solution.findLHS(nums2)); //  2

        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Output 3: " + solution.findLHS(nums3)); //  0
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int longestHarmoniousSubsequence = 0;

        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(key + 1)) {
                int currentLength = frequencyMap.get(key) + frequencyMap.get(key + 1);
                longestHarmoniousSubsequence = Math.max(longestHarmoniousSubsequence, currentLength);
            }
        }

        return longestHarmoniousSubsequence;
    }
}
