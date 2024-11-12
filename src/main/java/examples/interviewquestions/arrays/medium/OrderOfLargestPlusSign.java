package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] row : grid) {
            Arrays.fill(row, n);
        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = 0, up = 0, down = 0;
            for (int j = 0; j < n; j++) {
                left = (grid[i][j] == 0) ? 0 : left + 1;
                grid[i][j] = Math.min(grid[i][j], left);

                right = (grid[i][n - 1 - j] == 0) ? 0 : right + 1;
                grid[i][n - 1 - j] = Math.min(grid[i][n - 1 - j], right);

                up = (grid[j][i] == 0) ? 0 : up + 1;
                grid[j][i] = Math.min(grid[j][i], up);

                down = (grid[n - 1 - j][i] == 0) ? 0 : down + 1;
                grid[n - 1 - j][i] = Math.min(grid[n - 1 - j][i], down);
            }
        }

        int maxOrder = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxOrder = Math.max(maxOrder, grid[i][j]);
            }
        }

        return maxOrder;
    }

    public static void main(String[] args) {
        OrderOfLargestPlusSign solution = new OrderOfLargestPlusSign();
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
        System.out.println(solution.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
    }
}
