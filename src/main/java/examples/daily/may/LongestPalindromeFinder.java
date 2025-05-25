package examples.daily.may;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeFinder {
    public static void main(String[] args) {
        LongestPalindromeFinder longestPalindromeFinder = new LongestPalindromeFinder();

        String[] words1 = {"lc","cl","gg"};
        String[] words2 = {"ab","ty","yt","lc","cl","ab"};
        String[] words3 = {"cc","ll","xx"};

        System.out.println(longestPalindromeFinder.longestPalindrome(words1)); // 6
        System.out.println(longestPalindromeFinder.longestPalindrome(words2)); // 8
        System.out.println(longestPalindromeFinder.longestPalindrome(words3)); // 2
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int length = 0;

        for (String word : words) {
            String reversed = "" + word.charAt(1) + word.charAt(0);

            if (count.getOrDefault(reversed, 0) > 0) {
                length += 4;
                count.put(reversed, count.get(reversed) - 1);
            } else {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        for (String word : count.keySet()) {
            if (word.charAt(0) == word.charAt(1) && count.get(word) > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }
}
