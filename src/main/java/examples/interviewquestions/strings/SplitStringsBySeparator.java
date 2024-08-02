package examples.interviewquestions.strings;

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String[] splitParts = word.split("\\" + separator);
            for (String part : splitParts) {
                if (!part.isEmpty()) {
                    result.add(part);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SplitStringsBySeparator solution = new SplitStringsBySeparator();

        List<String> words = List.of("one.two.three", "four.five", "six");
        char separator = '.';
        List<String> result = solution.splitWordsBySeparator(words, separator);

        for (String str : result) {
            System.out.println(str);
        }

    }
}
