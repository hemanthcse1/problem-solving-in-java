package examples.daily.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxValidSubarraysWithConflicts {

    public static void main(String[] args) {
        MaxValidSubarraysWithConflicts solution = new MaxValidSubarraysWithConflicts();

        int n = 5;
        int[][] conflictingPairs = {
                {1, 3},
                {2, 5},
                {4, 5}
        };

        long result = solution.maxSubarrays(n, conflictingPairs);
        System.out.println("Maximum valid subarrays: " + result);
    }

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long validSubarrays = 0;
        int maxLeft = 0;
        int secondMaxLeft = 0;
        long[] gains = new long[n + 1];
        List<Integer>[] conflicts = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            conflicts[i] = new ArrayList<>();
        }

        for (int[] pair : conflictingPairs) {
            int a = pair[0];
            int b = pair[1];
            conflicts[Math.max(a, b)].add(Math.min(a, b));
        }

        for (int right = 1; right <= n; right++) {
            for (int left : conflicts[right]) {
                if (left > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = left;
                } else if (left > secondMaxLeft) {
                    secondMaxLeft = left;
                }
            }
            validSubarrays += right - maxLeft;
            gains[maxLeft] += maxLeft - secondMaxLeft;
        }

        return validSubarrays + Arrays.stream(gains).max().getAsLong();
    }
}
