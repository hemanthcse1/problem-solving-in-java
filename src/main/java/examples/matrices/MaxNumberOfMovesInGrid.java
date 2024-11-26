package examples.matrices;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNumberOfMovesInGrid {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxMoves = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
        }

        int[] dRow = {-1, 0, 1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                maxMoves = Math.max(maxMoves, col);

                for (int dir = 0; dir < 3; dir++) {
                    int newRow = row + dRow[dir];
                    int newCol = col + 1;

                    if (newRow >= 0 && newRow < m && newCol < n
                            && grid[newRow][newCol] > grid[row][col]
                            && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return maxMoves;
    }

    public static void main(String[] args) {
        MaxNumberOfMovesInGrid solver = new MaxNumberOfMovesInGrid();

        int[][] grid1 = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println(solver.maxMoves(grid1));

        int[][] grid2 = {
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        };
        System.out.println(solver.maxMoves(grid2));
    }
}
