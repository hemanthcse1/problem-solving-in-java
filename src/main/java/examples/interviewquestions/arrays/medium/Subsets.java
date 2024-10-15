package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);

            generateSubsets(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();

        int[] nums1 = {1, 2, 3};
        System.out.println(obj.subsets(nums1));

        int[] nums2 = {0};
        System.out.println(obj.subsets(nums2));
    }
}
