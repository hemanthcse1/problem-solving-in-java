package examples.interviewquestions.strings.easy;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {

    public static String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> results = new ArrayList<>();

        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                results.add(words[i + 2]);
            }
        }

        return results.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";

        String[] result = findOcurrences(text, first, second);

        for (String word : result) {
            System.out.println(word);
        }
    }
}
