package examples.interviewquestions.arrays.medium;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }
        if (fresh == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottenThisRound = false;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x<0||x>=m||y<0||y>=n||grid[x][y]!=1) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                    fresh--;
                    rottenThisRound = true;
                }
            }
            if (rottenThisRound) time++;
        }
        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
