package examples.daily.medium.january;

import java.util.ArrayList;
import java.util.List;

public class WordSubsetsSolution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = countFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freq = countFrequency(a);
            boolean universal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    universal = false;
                    break;
                }
            }
            if (universal) {
                result.add(a);
            }
        }
        return result;
    }

    private int[] countFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {
        WordSubsetsSolution solution = new WordSubsetsSolution();
        String[] words1a = {"amazon","apple","facebook","google","leetcode"};
        String[] words2a = {"e","o"};
        System.out.println(solution.wordSubsets(words1a, words2a));

        String[] words1b = {"amazon","apple","facebook","google","leetcode"};
        String[] words2b = {"l","e"};
        System.out.println(solution.wordSubsets(words1b, words2b));
    }
}
