package examples.interviewquestions.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int longestSubstringKDistinct(String s, int k) {
        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while (charFrequency.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        System.out.println("Length of the longest substring: " + longestSubstringKDistinct(s, k));
    }
}
