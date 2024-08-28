package examples.interviewquestions.hashmaps.easy;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public int[] findErrorNums(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];
        int repeating = -1, missing = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                freq[num]++;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (freq[i] == 2) {
                repeating = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues solver = new FindMissingAndRepeatedValues();

        int[][] grid = {
                {1, 2, 3},
                {4, 6, 6},
                {7, 8, 9}
        };

        int[] result = solver.findErrorNums(grid);
        System.out.println(Arrays.toString(result));
    }
}
