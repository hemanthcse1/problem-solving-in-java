package examples.interviewquestions.strings.easy;

import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", " ");
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }

    public static void main(String[] args) {
        // Example usage:
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String result = mostCommonWord(paragraph, banned);
        System.out.println("Most common word: " + result);  // Output should be "ball"
    }
}
