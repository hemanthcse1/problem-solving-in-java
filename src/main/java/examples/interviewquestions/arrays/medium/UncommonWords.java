package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : (s1 + " " + s2).split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        UncommonWords solution = new UncommonWords();

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(String.join(", ", solution.uncommonFromSentences(s1, s2)));

        String s1_2 = "apple apple";
        String s2_2 = "banana";
        System.out.println(String.join(", ", solution.uncommonFromSentences(s1_2, s2_2)));
    }
}
