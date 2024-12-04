package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class DivideIntervalsIntoGroups {

    // 2406. Divide Intervals Into Minimum Number of Groups

    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();

        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1] + 1, -1});
        }

        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int maxOverlap = 0, currentOverlap = 0;

        for (int[] event : events) {
            currentOverlap += event[1];
            maxOverlap = Math.max(maxOverlap, currentOverlap);
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        DivideIntervalsIntoGroups solution = new DivideIntervalsIntoGroups();
        System.out.println(solution.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
        System.out.println(solution.minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}}));
    }
}
