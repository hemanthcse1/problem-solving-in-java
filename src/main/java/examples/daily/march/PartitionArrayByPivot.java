package examples.daily.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayByPivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        int index = 0;
        for (int num : less) nums[index++] = num;
        for (int num : equal) nums[index++] = num;
        for (int num : greater) nums[index++] = num;

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        System.out.println("Original Array: " + Arrays.toString(nums));

        int[] result = pivotArray(nums, pivot);

        System.out.println("Partitioned Array: " + Arrays.toString(result));
    }
}
