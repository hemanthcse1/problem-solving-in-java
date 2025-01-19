package examples.daily.medium.january;

import java.util.PriorityQueue;

public class TrappingRainWaterII {

    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            pq.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][n - 1] = true;
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            pq.offer(new int[]{heightMap[0][j], 0, j});
            visited[m - 1][j] = true;
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
        }
        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int h = cell[0], r = cell[1], c = cell[2];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    water += Math.max(0, h - heightMap[nr][nc]);
                    pq.offer(new int[]{Math.max(h, heightMap[nr][nc]), nr, nc});
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[][] heightMap1 = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(trapRainWater(heightMap1));

        int[][] heightMap2 = {
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
        };
        System.out.println(trapRainWater(heightMap2));
    }
}
