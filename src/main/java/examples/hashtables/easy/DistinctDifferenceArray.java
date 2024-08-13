package examples.hashtables.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctDifferenceArray {
    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] suffixDistinctCount = new int[n];
        Set<Integer> suffixSet = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            suffixSet.add(nums[i]);
            suffixDistinctCount[i] = suffixSet.size();
        }
        int[] diff = new int[n];
        Set<Integer> prefixSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            prefixSet.add(nums[i]);
            int suffixCount = (i + 1 < n) ? suffixDistinctCount[i + 1] : 0;
            diff[i] = prefixSet.size() - suffixCount;
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 2, 1};
        int[] result = distinctDifferenceArray(nums);
        System.out.println(Arrays.toString(result));
    }
}
