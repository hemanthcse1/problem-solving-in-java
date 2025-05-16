package examples.daily.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestSubsequenceFinder {

    public static void main(String[] args) {
        LongestSubsequenceFinder longestSubsequenceFinder = new LongestSubsequenceFinder();

        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};

        List<String> longestSubsequence = longestSubsequenceFinder.getWordsInLongestSubsequence(words, groups);
        System.out.println("Longest subsequence with required conditions: " + longestSubsequence);
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int endIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j]
                        && words[i].length() == words[j].length()
                        && hammingDistance(words[i], words[j]) == 1) {

                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIdx = i;
            }
        }

        LinkedList<String> result = new LinkedList<>();

        while (endIdx != -1) {
            result.addFirst(words[endIdx]);
            endIdx = parent[endIdx];
        }

        return result;
    }

    private int hammingDistance(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) dist++;
        }
        return dist;
    }
}
