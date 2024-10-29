package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] patternMapping = getPatternMapping(pattern);

        for (String word : words) {
            if (matchesPattern(word, patternMapping)) {
                result.add(word);
            }
        }

        return result;
    }

    private int[] getPatternMapping(String word) {
        int[] mapping = new int[word.length()];
        HashMap<Character, Integer> charMap = new HashMap<>();
        int currentIndex = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            charMap.putIfAbsent(c, currentIndex++);
            mapping[i] = charMap.get(c);
        }

        return mapping;
    }

    private boolean matchesPattern(String word, int[] patternMapping) {
        int[] wordMapping = getPatternMapping(word);
        for (int i = 0; i < patternMapping.length; i++) {
            if (patternMapping[i] != wordMapping[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAndReplacePattern solution = new FindAndReplacePattern();

        String[] words1 = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern1 = "abb";
        System.out.println("Matching words for pattern 'abb': " + solution.findAndReplacePattern(words1, pattern1));

        String[] words2 = {"a", "b", "c"};
        String pattern2 = "a";
        System.out.println("Matching words for pattern 'a': " + solution.findAndReplacePattern(words2, pattern2));
    }
}
