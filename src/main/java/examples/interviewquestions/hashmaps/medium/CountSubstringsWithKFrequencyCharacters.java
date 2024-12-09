package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;

public class CountSubstringsWithKFrequencyCharacters {
    public int countSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            boolean validSubstring = false;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                if (freqMap.get(c) == k) {
                    validSubstring = true;
                }
                if (validSubstring) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubstringsWithKFrequencyCharacters solution = new CountSubstringsWithKFrequencyCharacters();
        System.out.println(solution.countSubstrings("abacb", 2));
        System.out.println(solution.countSubstrings("abcde", 1));
    }
}
