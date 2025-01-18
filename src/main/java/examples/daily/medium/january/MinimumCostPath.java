package examples.daily.medium.january;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MinimumCostPath {

    public static int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{0, 0});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int i = cur[0], j = cur[1];
            for (int k = 0; k < 4; k++) {
                int cost = (k == grid[i][j] - 1) ? 0 : 1;
                int ni = i + dirs[k][0], nj = j + dirs[k][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newCost = dist[i][j] + cost;
                    if (newCost < dist[ni][nj]) {
                        dist[ni][nj] = newCost;
                        if (cost == 0) dq.addFirst(new int[]{ni, nj});
                        else dq.addLast(new int[]{ni, nj});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        System.out.println(minCost(grid1)); // 3
        int[][] grid2 = {{1,1,3},{3,2,2},{1,1,4}};
        System.out.println(minCost(grid2)); // 0
        int[][] grid3 = {{1,2},{4,3}};
        System.out.println(minCost(grid3)); // 1
    }
}
