package examples.interviewquestions.arrays.medium;

import java.util.Arrays;
import java.util.TreeMap;

public class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> endTimeToMaxValue = new TreeMap<>();
        int maxSum = 0, rollingMax = 0;

        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2];

            Integer lastNonOverlapping = endTimeToMaxValue.floorKey(start - 1);
            int maxValueWithNonOverlap = (lastNonOverlapping != null ? endTimeToMaxValue.get(lastNonOverlapping) : 0);

            maxSum = Math.max(maxSum, value + maxValueWithNonOverlap);
            rollingMax = Math.max(rollingMax, value);

            endTimeToMaxValue.put(end, rollingMax);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        TwoBestNonOverlappingEvents solution = new TwoBestNonOverlappingEvents();

        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        System.out.println(solution.maxTwoEvents(events1));

        int[][] events2 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}, {6, 7, 10}};
        System.out.println(solution.maxTwoEvents(events2));
    }
}
