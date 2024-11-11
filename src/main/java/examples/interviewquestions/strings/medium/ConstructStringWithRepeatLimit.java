package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(charCount.keySet());

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int count = charCount.get(currentChar);

            int useCount = Math.min(count, repeatLimit);
            for (int i = 0; i < useCount; i++) {
                result.append(currentChar);
            }

            charCount.put(currentChar, count - useCount);

            if (count > repeatLimit) {
                if (maxHeap.isEmpty()) {
                    break;
                }

                char nextChar = maxHeap.poll();
                result.append(nextChar);

                charCount.put(nextChar, charCount.get(nextChar) - 1);

                if (charCount.get(nextChar) > 0) {
                    maxHeap.offer(nextChar);
                }
                maxHeap.offer(currentChar);
            } else if (charCount.get(currentChar) > 0) {
                maxHeap.offer(currentChar);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ConstructStringWithRepeatLimit solution = new ConstructStringWithRepeatLimit();
        System.out.println(solution.repeatLimitedString("cczazcc", 3));
        System.out.println(solution.repeatLimitedString("aababab", 2));
    }
}
