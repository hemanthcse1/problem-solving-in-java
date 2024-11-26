package examples.interviewquestions.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreak {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> streakMap = new HashMap<>();
        int maxStreak = -1;

        for (int num : nums) {
            int prevStreak = streakMap.getOrDefault((int) Math.sqrt(num), 0);
            if (prevStreak > 0 && Math.sqrt(num) == (int) Math.sqrt(num)) {
                streakMap.put(num, prevStreak + 1);
            } else {
                streakMap.put(num, 1);
            }
            maxStreak = Math.max(maxStreak, streakMap.get(num));
        }

        return maxStreak >= 2 ? maxStreak : -1;
    }

    public static void main(String[] args) {
        LongestSquareStreak solver = new LongestSquareStreak();

        int[] nums1 = {4, 3, 6, 16, 8, 2};
        System.out.println(solver.longestSquareStreak(nums1)); // Output: 3

        int[] nums2 = {2, 3, 5, 6, 7};
        System.out.println(solver.longestSquareStreak(nums2)); // Output: -1
    }
}
