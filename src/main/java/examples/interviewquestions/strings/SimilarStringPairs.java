package examples.interviewquestions.strings;

import java.util.HashSet;
import java.util.Set;

public class SimilarStringPairs {
    public static int countSimilarPairs(String[] words) {
        int count = 0;

        // Iterate through all pairs of words
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (areSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean areSimilar(String word1, String word2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : word1.toCharArray()) {
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            set2.add(c);
        }

        return set1.equals(set2);
    }

    public static void main(String[] args) {
        String[] words = {"abc", "bca", "cab", "xyz", "zyx"};
        int result = countSimilarPairs(words);
        System.out.println(result); // Output: 4
    }
}
