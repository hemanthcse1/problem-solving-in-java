package examples.daily;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumObstacleRemoval {

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        if (grid[nx][ny] == 0) deque.offerFirst(new int[]{nx, ny});
                        else deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumObstacleRemoval solver = new MinimumObstacleRemoval();
        int[][] grid1 = {{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(solver.minimumObstacles(grid1));

        int[][] grid2 = {{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}};
        System.out.println(solver.minimumObstacles(grid2));
    }
}
