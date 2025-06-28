package examples.daily.june;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSumSubsequence {

    public static void main(String[] args) {
        LargestSumSubsequence solution = new LargestSumSubsequence();
        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{2, 1, 3, 3}, 2))); // [3, 3]
        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{-1, -2, 3, 4}, 3))); // [-1, 3, 4]
        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{3, 4, 3, 3}, 2))); // [3, 4]
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] indexed = new int[n][2];


        for (int i = 0; i < n; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;
        }


        Arrays.sort(indexed, (a, b) -> b[0] - a[0]);


        Arrays.sort(indexed, 0, k, Comparator.comparingInt(a -> a[1]));


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = indexed[i][0];
        }

        return result;
    }

}
