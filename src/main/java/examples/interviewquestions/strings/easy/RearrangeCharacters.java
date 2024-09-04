package examples.interviewquestions.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharacters {

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int maxCopies = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCount.entrySet()) {
            char c = entry.getKey();
            int required = entry.getValue();
            int available = sCount.getOrDefault(c, 0);
            maxCopies = Math.min(maxCopies, available / required);
        }

        return maxCopies;
    }

    public static void main(String[] args) {
        RearrangeCharacters solution = new RearrangeCharacters();

        System.out.println(solution.rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
}
