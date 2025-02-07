package examples.daily.february;

import java.util.*;

public class DistinctColors {
    public static int[] distinctColors(int limit, int[][] queries) {
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        Set<Integer> uniqueColors = new HashSet<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    uniqueColors.remove(oldColor);
                }
            }

            ballColorMap.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            uniqueColors.add(color);

            result[i] = uniqueColors.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int limit1 = 4;
        int[][] queries1 = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        System.out.println(Arrays.toString(distinctColors(limit1, queries1)));

        int limit2 = 4;
        int[][] queries2 = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        System.out.println(Arrays.toString(distinctColors(limit2, queries2)));
    }
}
