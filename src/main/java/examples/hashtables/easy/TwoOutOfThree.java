package examples.hashtables.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : nums3) {
            set3.add(num);
        }
        for (int num : set1) {
            if (set2.contains(num) || set3.contains(num)) {
                resultSet.add(num);
            }
        }
        for (int num : set2) {
            if (set3.contains(num)) {
                resultSet.add(num);
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        TwoOutOfThree solution = new TwoOutOfThree();
        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        List<Integer> result = solution.twoOutOfThree(nums1, nums2, nums3);
        System.out.println(result);
    }
}
