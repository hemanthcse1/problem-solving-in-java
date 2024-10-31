package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();

        while (maxHeap.size() > 1) {
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();

            result.append(first.getKey());
            result.append(second.getKey());

            if (first.getValue() > 1) {
                first.setValue(first.getValue() - 1);
                maxHeap.offer(first);
            }
            if (second.getValue() > 1) {
                second.setValue(second.getValue() - 1);
                maxHeap.offer(second);
            }
        }

        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> last = maxHeap.poll();
            if (last.getValue() > 1) {
                return "";
            }
            result.append(last.getKey());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReorganizeString solution = new ReorganizeString();

        System.out.println(solution.reorganizeString("aab"));
        System.out.println(solution.reorganizeString("aaab"));
    }
}
