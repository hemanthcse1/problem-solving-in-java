package examples.daily.july;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValueEvents {
    public int maxValue(int[][] events, int k) {
        Integer[][] dp = new Integer[events.length][k + 1];
        Arrays.sort(events, Comparator.comparingInt((int[] e) -> e[0]).thenComparingInt(e -> e[1]));
        return maxValue(events, 0, k, dp);
    }

    private int maxValue(int[][] events, int i, int k, Integer[][] dp) {
        if (k == 0 || i == events.length) return 0;
        if (dp[i][k] != null) return dp[i][k];
        int j = nextIndex(events, i + 1, events[i][1] + 1);
        int take = events[i][2] + maxValue(events, j, k - 1, dp);
        int skip = maxValue(events, i + 1, k, dp);
        return dp[i][k] = Math.max(take, skip);
    }

    private int nextIndex(int[][] events, int l, int target) {
        int r = events.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (events[m][0] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        MaxValueEvents solver = new MaxValueEvents();
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;
        int result = solver.maxValue(events, k);
        System.out.println("Maximum value of events attended: " + result);
    }
}
