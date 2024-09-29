package examples.interviewquestions.arrays.easy;

import java.util.HashSet;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int smallestMissingIntegerGreaterThanSequentialPrefixSum(int[] nums) {
        int sum = nums[0];
        int i = 1;

        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        while (numSet.contains(sum)) {
            sum++;
        }

        return sum;
    }

    public static void main(String[] args) {
        SmallestMissingIntegerGreaterThanSequentialPrefixSum solution = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();
        System.out.println(solution.smallestMissingIntegerGreaterThanSequentialPrefixSum(new int[]{1, 2, 3, 2, 5}));
        System.out.println(solution.smallestMissingIntegerGreaterThanSequentialPrefixSum(new int[]{3, 4, 5, 1, 12, 14, 13}));
    }
}
