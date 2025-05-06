package examples.daily.may;

import java.util.Arrays;

public class ArrayPermutationTester {

    public static void main(String[] args) {
        ArrayPermutationTester solution = new ArrayPermutationTester();

        int[] nums = {0, 2, 1, 5, 3, 4};

        int[] result = solution.buildArray(nums);

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Permuted Array: " + Arrays.toString(result));
    }

    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }
}
