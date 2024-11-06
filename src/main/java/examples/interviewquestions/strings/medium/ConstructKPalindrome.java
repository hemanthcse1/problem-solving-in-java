package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindrome {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : freqMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }

    public static void main(String[] args) {
        ConstructKPalindrome solution = new ConstructKPalindrome();

        System.out.println(solution.canConstruct("annabelle", 2));
        System.out.println(solution.canConstruct("leetcode", 3));
        System.out.println(solution.canConstruct("true", 4));
    }
}
