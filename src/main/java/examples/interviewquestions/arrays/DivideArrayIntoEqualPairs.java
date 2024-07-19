package examples.interviewquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int count : countMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3, 2, 2, 2};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(divideArray(nums1));
        System.out.println(divideArray(nums2));
    }
}
