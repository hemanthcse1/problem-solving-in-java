package examples.interviewquestions.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringEvenVowels {

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1);
        int state = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                state ^= 1 << 0;
            } else if (c == 'e') {
                state ^= 1 << 1;
            } else if (c == 'i') {
                state ^= 1 << 2;
            } else if (c == 'o') {
                state ^= 1 << 3;
            } else if (c == 'u') {
                state ^= 1 << 4;
            }

            if (stateMap.containsKey(state)) {
                maxLength = Math.max(maxLength, i - stateMap.get(state));
            } else {
                stateMap.put(state, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringEvenVowels solution = new LongestSubstringEvenVowels();

        String s1 = "eleetminicoworoep";
        System.out.println(solution.findTheLongestSubstring(s1)); // Output: 13

        String s2 = "leetcodeisgreat";
        System.out.println(solution.findTheLongestSubstring(s2)); // Output: 5

        String s3 = "bcbcbc";
        System.out.println(solution.findTheLongestSubstring(s3)); // Output: 6
    }
}
