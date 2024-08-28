package examples.interviewquestions.hashmaps.easy;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElements {
    public int[] findCommonElements(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        int answer1 = 0;
        for (int num : nums1) {
            if (set2.contains(num)) {
                answer1++;
            }
        }
        int answer2 = 0;
        for (int num : nums2) {
            if (set1.contains(num)) {
                answer2++;
            }
        }

        return new int[]{answer1, answer2};
    }

    public static void main(String[] args) {
        FindCommonElements solver = new FindCommonElements();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 3, 4, 5};
        int[] result = solver.findCommonElements(nums1, nums2);

        System.out.println("answer1: " + result[0] + ", answer2: " + result[1]);
    }
}
