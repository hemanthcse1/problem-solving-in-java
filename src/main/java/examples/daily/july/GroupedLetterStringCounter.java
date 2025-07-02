package examples.daily.july;

import java.util.ArrayList;
import java.util.List;

public class GroupedLetterStringCounter {

    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        List<Integer> groups = getConsecutiveLetterGroups(word);
        int totalCombinations = 1;
        for (int count : groups)
            totalCombinations = (int)((1L * totalCombinations * count) % MOD);

        if (k <= groups.size())
            return totalCombinations;

        int[] dp = new int[k];
        dp[0] = 1;

        for (int group : groups) {
            int[] nextDp = new int[k];
            int windowSum = 0;
            for (int j = 0; j < k; ++j) {
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= group)
                    windowSum = (windowSum - dp[j - group] + MOD) % MOD;
                nextDp[j] = windowSum;
            }
            dp = nextDp;
        }

        int invalid = 0;
        for (int val : dp)
            invalid = (invalid + val) % MOD;

        return (totalCombinations - invalid + MOD) % MOD;
    }

    private List<Integer> getConsecutiveLetterGroups(String word) {
        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) == word.charAt(i - 1))
                count++;
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);
        return groups;
    }

    public static void main(String[] args) {
        GroupedLetterStringCounter counter = new GroupedLetterStringCounter();

        String word = "aaabbccc";
        int k = 5;

        int result = counter.possibleStringCount(word, k);
        System.out.println("Number of valid strings of length " + k + " from word '" + word + "': " + result);
    }


}
