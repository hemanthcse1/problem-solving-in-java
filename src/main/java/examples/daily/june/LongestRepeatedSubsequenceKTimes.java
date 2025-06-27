package examples.daily.june;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LongestRepeatedSubsequenceKTimes {
    public static void main(String[] args) {
        LongestRepeatedSubsequenceKTimes longestRepeatedSubsequenceKTimes = new LongestRepeatedSubsequenceKTimes();

        String s = "letsleetcode";
        int k = 2;

        String result = longestRepeatedSubsequenceKTimes.longestSubsequenceRepeatedK(s, k);
        System.out.println("Longest repeated subsequence that appears " + k + " times: " + result);
    }
    public String longestSubsequenceRepeatedK(String s, int k) {
        String result = "";
        int[] charFrequency = new int[26];

        for (char ch : s.toCharArray()) {
            charFrequency[ch - 'a']++;
        }

        List<Character> validChars = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (charFrequency[ch - 'a'] >= k) {
                validChars.add(ch);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer("");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.length() * k > s.length()) {
                return result;
            }

            for (char ch : validChars) {
                String newSubsequence = current + ch;
                if (appearsKTimesAsSubsequence(newSubsequence, s, k)) {
                    queue.offer(newSubsequence);
                    result = newSubsequence;
                }
            }
        }

        return result;
    }

    private boolean appearsKTimesAsSubsequence(String pattern, String s, int k) {
        int matchIndex = 0;

        for (char ch : s.toCharArray()) {
            if (ch == pattern.charAt(matchIndex)) {
                matchIndex++;
                if (matchIndex == pattern.length()) {
                    k--;
                    if (k == 0) return true;
                    matchIndex = 0;
                }
            }
        }

        return false;
    }
}
