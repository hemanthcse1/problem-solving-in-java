package examples.interviewquestions.twopointers;

import java.util.HashSet;
import java.util.Set;

public class ArithmeticTriplets {
    public int countArithmeticTriplets(int[] nums, int diff) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int count = 0;
        for (int num : nums) {
            if (numSet.contains(num + diff) && numSet.contains(num + 2 * diff)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ArithmeticTriplets solution = new ArithmeticTriplets();
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int result = solution.countArithmeticTriplets(nums, diff);
        System.out.println("Number of unique arithmetic triplets: " + result);
    }
}
