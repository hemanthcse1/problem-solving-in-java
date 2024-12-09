package examples.interviewquestions.hashmaps.medium;

import java.util.Arrays;

public class MaximumPointsInsideSquare {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int d = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            arr[i][0] = d;
            arr[i][1] = s.charAt(i) - 'a';
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] freq = new int[26];
        int count = 0;
        int maxAns = 0;
        int prevD = -1;
        int i = 0;

        while (i < n) {
            int d = arr[i][0];

            int start = i;
            while (i < n && arr[i][0] == d) {
                int tag = arr[i][1];
                if (freq[tag] == 1) {
                    return maxAns;
                }
                freq[tag]++;
                count++;
                i++;
            }
            maxAns = Math.max(maxAns, count);
            prevD = d;
        }

        return maxAns;
    }

    public static void main(String[] args) {
        MaximumPointsInsideSquare solution = new MaximumPointsInsideSquare();
        System.out.println(solution.maxPointsInsideSquare(
                new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}}, "abdca"));
        System.out.println(solution.maxPointsInsideSquare(
                new int[][]{{1, 1}, {-2, -2}, {-2, 2}}, "abb"));
    }
}
