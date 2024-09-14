package examples.interviewquestions.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class RepeatedNTimes {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        RepeatedNTimes solution = new RepeatedNTimes();

        int[] nums1 = {1, 2, 3, 3};
        System.out.println(solution.repeatedNTimes(nums1));

        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println(solution.repeatedNTimes(nums2));

        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(solution.repeatedNTimes(nums3));
    }
}
