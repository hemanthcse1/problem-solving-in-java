package examples.daily.medium.january;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }


        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];


            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (result[nr][nc] == -1) {

                        result[nr][nc] = result[r][c] + 1;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] isWater1 = {
                {0,1},
                {0,0}
        };
        int[][] res1 = highestPeak(isWater1);

        printMatrix(res1);

        int[][] isWater2 = {
                {0,0,1},
                {1,0,0},
                {0,0,0}
        };
        int[][] res2 = highestPeak(isWater2);

        printMatrix(res2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
