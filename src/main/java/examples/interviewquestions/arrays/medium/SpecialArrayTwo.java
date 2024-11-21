package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class SpecialArrayTwo {
    public boolean[] specialArray(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] result = new boolean[queries.length];

        if (n == 1) {
            for (int i = 0; i < queries.length; i++) {
                result[i] = true;
            }
            return result;
        }

        int[] parity = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            parity[i] = (nums[i] % 2) != (nums[i + 1] % 2) ? 1 : 0;
        }

        int[] prefix = new int[n - 1];
        prefix[0] = parity[0];
        for (int i = 1; i < n - 1; i++) {
            prefix[i] = prefix[i - 1] + parity[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            boolean isValid = true;

            if (from == to) {
                result[i] = true;
                continue;
            }

            int count = prefix[to - 1] - (from > 0 ? prefix[from - 1] : 0);
            if (count != to - from) {
                isValid = false;
            }
            result[i] = isValid;
        }

        return result;
    }

    public static void main(String[] args) {
        SpecialArrayTwo solution = new SpecialArrayTwo();

        int[] nums1 = {3, 4, 1, 2, 6};
        int[][] queries1 = {{0, 4}};
        System.out.println(Arrays.toString(solution.specialArray(nums1, queries1)));

        int[] nums2 = {4, 3, 1, 6};
        int[][] queries2 = {{0, 2}, {2, 3}};
        System.out.println(Arrays.toString(solution.specialArray(nums2, queries2)));

        int[] nums3 = {1};
        int[][] queries3 = {{0, 0}};
        System.out.println(Arrays.toString(solution.specialArray(nums3, queries3)));
    }
}
