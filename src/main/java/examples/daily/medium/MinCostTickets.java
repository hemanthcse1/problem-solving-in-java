package examples.daily.medium;

import java.util.HashSet;
import java.util.Set;

public class MinCostTickets {
    public static void main(String[] args) {
        int[] days1 = {1,4,6,7,8,20};
        int[] costs1 = {2,7,15};
        System.out.println(mincostTickets(days1, costs1));

        int[] days2 = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs2 = {2,7,15};
        System.out.println(mincostTickets(days2, costs2));
    }

    public static int mincostTickets(int[] days, int[] costs) {

        int maxDay = days[days.length - 1];

        int[] dp = new int[maxDay + 1];
        Set<Integer> travelDays = new HashSet<>();
        for (int d : days) {
            travelDays.add(d);
        }

        for (int i = 1; i <= maxDay; i++) {

            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            int cost1 = dp[Math.max(0, i - 1)] + costs[0];
            int cost7 = dp[Math.max(0, i - 7)] + costs[1];
            int cost30 = dp[Math.max(0, i - 30)] + costs[2];
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[maxDay];
    }
}
