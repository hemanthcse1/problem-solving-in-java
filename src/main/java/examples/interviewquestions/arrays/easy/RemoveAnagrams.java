package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!areAnagrams(words[i], result.get(result.size() - 1))) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean areAnagrams(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        RemoveAnagrams solution = new RemoveAnagrams();

        String[] words1 = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(solution.removeAnagrams(words1));

        String[] words2 = {"a", "b", "c", "d", "e"};
        System.out.println(solution.removeAnagrams(words2));
    }
}
