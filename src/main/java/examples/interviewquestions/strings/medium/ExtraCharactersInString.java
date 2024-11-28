package examples.interviewquestions.strings.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInString {


    public int minExtraChar(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (wordSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ExtraCharactersInString solver = new ExtraCharactersInString();

        String s1 = "leetscode";
        String[] dictionary1 = {"leet", "code", "leetcode"};
        System.out.println(solver.minExtraChar(s1, dictionary1));

        String s2 = "sayhelloworld";
        String[] dictionary2 = {"hello", "world"};
        System.out.println(solver.minExtraChar(s2, dictionary2));
    }
}
