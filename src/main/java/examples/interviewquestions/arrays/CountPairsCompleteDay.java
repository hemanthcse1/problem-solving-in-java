package examples.interviewquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountPairsCompleteDay {
    public static int countPairs(int[] hours) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;

        for (int hour : hours) {
            int remainder = hour % 24;

            int complement = (24 - remainder) % 24;

            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] hours = {1, 23, 24, 25, 47};
        System.out.println(countPairs(hours));
    }
}
