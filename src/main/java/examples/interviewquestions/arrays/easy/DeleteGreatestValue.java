package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int maxDeletedValue = 0;
            for (int[] row : grid) {
                int maxInRow = Integer.MIN_VALUE;
                int maxIndex = -1;

                for (int j = 0; j < row.length; j++) {
                    if (row[j] > maxInRow) {
                        maxInRow = row[j];
                        maxIndex = j;
                    }
                }

                row[maxIndex] = Integer.MIN_VALUE;
                if (maxInRow > maxDeletedValue) {
                    maxDeletedValue = maxInRow;
                }
            }

            answer += maxDeletedValue;

            for (int[] row : grid) {
                row = Arrays.stream(row).filter(value -> value != Integer.MIN_VALUE).toArray();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        DeleteGreatestValue solution = new DeleteGreatestValue();
        int[][] grid = {
                {1, 2, 4},
                {3, 3, 1},
                {5, 6, 2}
        };
        int result = solution.deleteGreatestValue(grid);
        System.out.println("Final answer: " + result);
    }
}
