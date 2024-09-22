package examples.interviewquestions.arrays.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinOperations {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> collected = new HashSet<>();
        int operations = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            int current = nums.get(i);
            if (current <= k) {
                collected.add(current);
            }
            operations++;

            if (collected.size() == k) {
                return operations;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        MinOperations sol = new MinOperations();
        List<Integer> nums1 = List.of(3, 1, 5, 4, 2);
        System.out.println(sol.minOperations(nums1, 2));

        List<Integer> nums2 = List.of(3, 1, 5, 4, 2);
        System.out.println(sol.minOperations(nums2, 5));

        List<Integer> nums3 = List.of(3, 2, 5, 3, 1);
        System.out.println(sol.minOperations(nums3, 3));
    }
}
