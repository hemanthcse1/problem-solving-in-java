package examples.daily;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder complement = new StringBuilder();

            for (int value : row) {
                if (row[0] == 0) {
                    pattern.append(value);
                    complement.append(1 - value);
                } else {
                    pattern.append(1 - value);
                    complement.append(value);
                }
            }

            String key = pattern.toString();
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
        }

        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

    public static void main(String[] args) {
        FlipColumnsForEqualRows solution = new FlipColumnsForEqualRows();

        int[][] matrix1 = {{0, 1}, {1, 1}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix1));

        int[][] matrix2 = {{0, 1}, {1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix2));

        int[][] matrix3 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix3));
    }
}
