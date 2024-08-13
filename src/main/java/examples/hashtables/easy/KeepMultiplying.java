package examples.hashtables.easy;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplying {
    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        while (numSet.contains(original)) {
            original *= 2;
        }

        return original;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        int result = findFinalValue(nums, original);
        System.out.println("Final value of original: " + result);
    }
}
