package examples.interviewquestions.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FormSmallestNumber {
    public static int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        int commonMin = Integer.MAX_VALUE;

        for (int num : nums2) {
            if (set1.contains(num)) {
                commonMin = Math.min(commonMin, num);
            }
        }

        if (commonMin != Integer.MAX_VALUE) {
            return commonMin;
        }

        int min1 = Arrays.stream(nums1).min().getAsInt();
        int min2 = Arrays.stream(nums2).min().getAsInt();

        return Math.min(min1 * 10 + min2, min2 * 10 + min1);
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 3};
        int[] nums2 = {5, 7};
        System.out.println(minNumber(nums1, nums2));

        int[] nums1_2 = {3, 5, 2, 6};
        int[] nums2_2 = {3, 1, 7};
        System.out.println(minNumber(nums1_2, nums2_2));
    }
}
