package examples.daily;

import java.util.Arrays;

public class FindScore {
    public static long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        long score = 0;
        for (int[] pair : arr) {
            int val = pair[0], idx = pair[1];
            if (!marked[idx]) {
                score += val;
                marked[idx] = true;
                if (idx - 1 >= 0) marked[idx - 1] = true;
                if (idx + 1 < n) marked[idx + 1] = true;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};
        System.out.println(findScore(nums));
    }
}
