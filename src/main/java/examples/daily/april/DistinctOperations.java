package examples.daily.april;

import java.util.*;

public class DistinctOperations {

    public int minimumOperations(int[] nums) {
        int operations = 0;
        int start = 0;

        while (containsDuplicates(nums, start)) {
            start += 3;
            operations++;
            if (start >= nums.length) break;
        }

        return operations;
    }

    private boolean containsDuplicates(int[] nums, int start) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        DistinctOperations sol = new DistinctOperations();
        System.out.println(sol.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7})); //  2
        System.out.println(sol.minimumOperations(new int[]{4, 5, 6, 4, 4}));           //  2
        System.out.println(sol.minimumOperations(new int[]{6, 7, 8, 9}));              //  0
    }
}
