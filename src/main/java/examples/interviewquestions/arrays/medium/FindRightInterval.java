package examples.interviewquestions.arrays.medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        Integer[] originalIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            originalIndices[i] = i;
        }

        Arrays.sort(originalIndices, Comparator.comparingInt(i -> intervals[i][0]));

        for (int i = 0; i < n; i++) {
            int[] interval = intervals[originalIndices[i]];
            int targetEnd = interval[1];

            int lo = i + 1, hi = n - 1, idx = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (intervals[originalIndices[mid]][0] >= targetEnd) {
                    idx = originalIndices[mid];
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            result[originalIndices[i]] = idx == -1 ? -1 : idx;
        }

        return result;
    }

    public static void main(String[] args) {
        FindRightInterval sol = new FindRightInterval();


        int[][] intervals1 = {{1, 2}};
        int[] result1 = sol.findRightInterval(intervals1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1));

        int[][] intervals2 = {{3, 4}, {2, 3}, {1, 2}};
        int[] result2 = sol.findRightInterval(intervals2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2));


    }
}
