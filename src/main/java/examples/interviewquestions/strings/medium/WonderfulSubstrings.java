package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class WonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> maskCount = new HashMap<>();
        maskCount.put(0, 1);
        int mask = 0;
        long result = 0;

        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');

            result += maskCount.getOrDefault(mask, 0);

            for (int i = 0; i < 10; i++) {
                int maskWithOneBitFlipped = mask ^ (1 << i);
                result += maskCount.getOrDefault(maskWithOneBitFlipped, 0);
            }

            maskCount.put(mask, maskCount.getOrDefault(mask, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        WonderfulSubstrings ws = new WonderfulSubstrings();
        System.out.println(ws.wonderfulSubstrings("aba"));
        System.out.println(ws.wonderfulSubstrings("aabb"));
        System.out.println(ws.wonderfulSubstrings("he"));
    }
}
