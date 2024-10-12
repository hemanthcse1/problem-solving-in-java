package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOne {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(result, nums, start + 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        PermutationsOne solution = new PermutationsOne();

        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.permute(nums1);
        System.out.println("Permutations of [1, 2, 3]: " + result1);

        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println("Permutations of [0, 1]: " + result2);

        int[] nums3 = {1};
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println("Permutations of [1]: " + result3);
    }
}
