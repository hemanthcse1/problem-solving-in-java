package examples.daily.may;

import java.util.ArrayList;
import java.util.List;

public class LongestSubsequenceMain {

    public static void main(String[] args) {
        LongestSubsequenceMain solution = new LongestSubsequenceMain();

        String[] words = {"apple", "banana", "cherry", "date", "fig", "grape"};
        int[] groups = {0, 1, 1, 0, 0, 1};

        List<String> longestSubsequence = solution.getLongestSubsequence(words, groups);
        System.out.println("Longest subsequence with alternating groups: " + longestSubsequence);
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        result.add(words[0]);

        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }

        return result;
    }
}
