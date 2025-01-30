package examples.interviewquestions.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);

            if (targetCount.containsKey(rightChar) && windowCount.get(rightChar).intValue() == targetCount.get(rightChar).intValue()) {
                matched++;
            }

            while (matched == targetCount.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    matched--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); //  "BANC"
        System.out.println(solution.minWindow("a", "a")); //  "a"
        System.out.println(solution.minWindow("a", "aa")); //  ""
    }
}
