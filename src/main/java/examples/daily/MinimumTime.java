package examples.daily;

import java.util.PriorityQueue;

public class MinimumTime {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], r = curr[1], c = curr[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r == m - 1 && c == n - 1) return time;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    int waitTime = 0;
                    if (time + 1 < grid[nr][nc]) {
                        waitTime = grid[nr][nc] - (time + 1);
                        if (waitTime % 2 == 1) waitTime++;
                    }
                    pq.offer(new int[]{time + 1 + waitTime, nr, nc});
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        MinimumTime solution = new MinimumTime();

        int[][] grid1 = {
                {0, 2, 4},
                {3, 2, 1},
                {4, 3, 0}
        };
        int result1 = solution.minimumTime(grid1);
        System.out.println("Minimum time to reach the bottom-right corner (grid1): " + result1);

        int[][] grid2 = {
                {0, 2},
                {2, 0}
        };
        int result2 = solution.minimumTime(grid2);
        System.out.println("Minimum time to reach the bottom-right corner (grid2): " + result2);

        int[][] grid3 = {
                {0, 2, 4},
                {3, 2, 1},
                {4, 3, 6}
        };
        int result3 = solution.minimumTime(grid3);
        System.out.println("Minimum time to reach the bottom-right corner (grid3): " + result3);
    }

}
