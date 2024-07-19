package examples.interviewquestions.arrays;

import java.util.*;

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            Set<Character> wordSet = new HashSet<>();
            for (char c : lowerWord.toCharArray()) {
                wordSet.add(c);
            }

            if (row1.containsAll(wordSet) || row2.containsAll(wordSet) || row3.containsAll(wordSet)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] words1 = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words2 = {"omg", "Yes", "No"};

        System.out.println(Arrays.toString(findWords(words1)));
        System.out.println(Arrays.toString(findWords(words2)));
    }
}
