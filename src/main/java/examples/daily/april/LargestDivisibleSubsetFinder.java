package examples.daily.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubsetFinder {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 4, 8};

        System.out.println(findLargestDivisibleSubset(nums1));
        System.out.println(findLargestDivisibleSubset(nums2));
    }

    public static List<Integer> findLargestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxIndex = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = maxIndex;
        while (i >= 0) {
            result.add(nums[i]);
            i = prev[i];
        }

        Collections.reverse(result);
        return result;
    }
}
