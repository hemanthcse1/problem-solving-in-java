package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tempList.add(nums[i]);

            backtrack(result, tempList, nums, visited);

            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsTwo solution = new PermutationsTwo();

        int[] nums1 = {1, 1, 2};
        List<List<Integer>> result1 = solution.permuteUnique(nums1);
        System.out.println("Unique Permutations of [1, 1, 2]: " + result1);

        int[] nums2 = {1, 2, 3};
        List<List<Integer>> result2 = solution.permuteUnique(nums2);
        System.out.println("Unique Permutations of [1, 2, 3]: " + result2);
    }
}
