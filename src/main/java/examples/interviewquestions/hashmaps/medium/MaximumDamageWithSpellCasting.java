package examples.interviewquestions.hashmaps.medium;

import java.util.*;

public class MaximumDamageWithSpellCasting {
    public long maxDamage(int[] power) {
        Arrays.sort(power);
        TreeMap<Integer, Long> damageFrequency = new TreeMap<>();
        for (int damage : power) {
            damageFrequency.put(damage, damageFrequency.getOrDefault(damage, 0L) + damage);
        }

        List<Integer> sortedDamages = new ArrayList<>(damageFrequency.keySet());
        long[] dp = new long[sortedDamages.size()];
        dp[0] = damageFrequency.get(sortedDamages.get(0));

        for (int i = 1; i < sortedDamages.size(); i++) {
            int currentDamage = sortedDamages.get(i);
            long currentDamageTotal = damageFrequency.get(currentDamage);
            dp[i] = currentDamageTotal;

            for (int j = i - 1; j >= 0; j--) {
                if (sortedDamages.get(j) < currentDamage - 2) {
                    dp[i] = Math.max(dp[i], dp[j] + currentDamageTotal);
                    break;
                }
            }

            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        return dp[sortedDamages.size() - 1];
    }

    public static void main(String[] args) {
        MaximumDamageWithSpellCasting sol = new MaximumDamageWithSpellCasting();
        System.out.println(sol.maxDamage(new int[]{7, 1, 6, 6}));
        System.out.println(sol.maxDamage(new int[]{722864766,888839454,432490795}));
    }
}
