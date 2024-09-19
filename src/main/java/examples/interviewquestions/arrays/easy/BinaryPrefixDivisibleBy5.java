package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;

        for (int num : nums) {
            prefix = (prefix * 2 + num) % 5;

            result.add(prefix == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 solution = new BinaryPrefixDivisibleBy5();

        int[] nums1 = {0, 1, 1};
        System.out.println("Test case 1 output: " + solution.prefixesDivBy5(nums1));

        int[] nums2 = {1, 1, 1};
        System.out.println("Test case 2 output: " + solution.prefixesDivBy5(nums2));

        int[] nums3 = {1, 0, 1, 0, 1};
        System.out.println("Test case 3 output: " + solution.prefixesDivBy5(nums3));
    }
}
