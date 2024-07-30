package examples.problems;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> frequencies = new HashSet<>();
        for (int freq : frequencyMap.values()) {
            if (!frequencies.add(freq)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean result = uniqueOccurrences(arr);
        System.out.println("Are occurrences unique? " + result);
    }
}
