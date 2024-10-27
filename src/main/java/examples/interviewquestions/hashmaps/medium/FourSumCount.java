package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                if (sumMap.containsKey(target)) {
                    count += sumMap.get(target);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSumCount solution = new FourSumCount();

        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));

        int[] nums1_2 = {0};
        int[] nums2_2 = {0};
        int[] nums3_2 = {0};
        int[] nums4_2 = {0};
        System.out.println(solution.fourSumCount(nums1_2, nums2_2, nums3_2, nums4_2));
    }
}
