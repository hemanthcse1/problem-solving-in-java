package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class FindLHS {

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

    public static void main(String[] args) {
        FindLHS solution = new FindLHS();

        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(solution.findLHS(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.findLHS(nums2));

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(solution.findLHS(nums3));
    }
}
