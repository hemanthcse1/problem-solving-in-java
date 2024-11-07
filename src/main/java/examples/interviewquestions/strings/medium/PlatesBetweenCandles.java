package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] result = new int[queries.length];

        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] platePrefixSum = new int[n + 1];

        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            leftCandle[i] = lastCandle;
        }

        lastCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            rightCandle[i] = lastCandle;
        }

        for (int i = 0; i < n; i++) {
            platePrefixSum[i + 1] = platePrefixSum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int leftBoundary = rightCandle[left];
            int rightBoundary = leftCandle[right];

            if (leftBoundary != -1 && rightBoundary != -1 && leftBoundary <= rightBoundary) {
                result[i] = platePrefixSum[rightBoundary + 1] - platePrefixSum[leftBoundary];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles solution = new PlatesBetweenCandles();

        String s1 = "**|**|***|";
        int[][] queries1 = {{2, 5}, {5, 9}};
        System.out.println(Arrays.toString(solution.platesBetweenCandles(s1, queries1)));

        String s2 = "***|**|*****|**||**|*";
        int[][] queries2 = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        System.out.println(Arrays.toString(solution.platesBetweenCandles(s2, queries2)));
    }
}
