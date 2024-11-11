package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class CountVowelStringsInRange {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefix[ri + 1] - prefix[li];
        }

        return result;
    }

    private boolean isVowelString(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        CountVowelStringsInRange solution = new CountVowelStringsInRange();
        String[] words1 = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries1 = {{0, 2}, {1, 4}, {1, 1}};
        int[] result1 = solution.vowelStrings(words1, queries1);

        String[] words2 = {"a", "e", "i"};
        int[][] queries2 = {{0, 2}, {0, 1}, {2, 2}};
        int[] result2 = solution.vowelStrings(words2, queries2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
