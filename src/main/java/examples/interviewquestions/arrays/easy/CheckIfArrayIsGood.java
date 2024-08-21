package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayIsGood {
    public static boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        if (maxNum != n) {
            return false;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n - 1; i++) {
            if (!frequencyMap.containsKey(i) || frequencyMap.get(i) != 1) {
                return false;
            }
        }

        return frequencyMap.getOrDefault(n, 0) == 2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 2};
        int[] nums3 = {1, 1, 2, 2};

        System.out.println(isGood(nums1)); // Output: true
        System.out.println(isGood(nums2)); // Output: true
        System.out.println(isGood(nums3)); // Output: false
    }
}
