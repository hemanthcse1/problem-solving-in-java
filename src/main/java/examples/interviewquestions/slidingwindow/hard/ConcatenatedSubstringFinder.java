package examples.interviewquestions.slidingwindow.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedSubstringFinder {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int windowSize = totalWords * wordLen;

        if (s.length() < windowSize) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ConcatenatedSubstringFinder finder = new ConcatenatedSubstringFinder();

        System.out.println(finder.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); // [0,9]
        System.out.println(finder.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"})); // []

    }
}
