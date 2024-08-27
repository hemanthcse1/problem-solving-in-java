package examples.interviewquestions.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class EqualFrequency {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> frequencyCountMap = new HashMap<>();
        for (int freq : frequencyMap.values()) {
            frequencyCountMap.put(freq, frequencyCountMap.getOrDefault(freq, 0) + 1);
        }

        if (frequencyCountMap.size() == 1) {
            return frequencyCountMap.containsKey(1) || frequencyMap.size() == 1;
        } else if (frequencyCountMap.size() == 2) {
            int minFreq = Integer.MAX_VALUE, maxFreq = Integer.MIN_VALUE;

            for (int freq : frequencyCountMap.keySet()) {
                minFreq = Math.min(minFreq, freq);
                maxFreq = Math.max(maxFreq, freq);
            }

            if (frequencyCountMap.get(maxFreq) == 1 && maxFreq - minFreq == 1) {
                return true;
            } else if (minFreq == 1 && frequencyCountMap.get(minFreq) == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        EqualFrequency solver = new EqualFrequency();

        System.out.println(solver.equalFrequency("abcc")); // true
        System.out.println(solver.equalFrequency("aazz")); // false
    }
}
