package examples.interviewquestions.slidingwindow.easy;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubstring {
    public static int maxLengthSubstringWithTwoOccurrences(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int start = 0, maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            charCount.put(endChar, charCount.getOrDefault(endChar, 0) + 1);
            while (charCount.get(endChar) > 2) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = maxLengthSubstringWithTwoOccurrences(s);
        System.out.println("The maximum length of substring with at " +
                "most two occurrences of each character is: " + result);
    }
}
