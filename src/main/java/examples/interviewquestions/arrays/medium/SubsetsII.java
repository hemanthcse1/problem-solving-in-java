package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();

        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets for nums1: " + solution.subsetsWithDup(nums1));

        int[] nums2 = {0};
        System.out.println("Subsets for nums2: " + solution.subsetsWithDup(nums2));
    }
}
