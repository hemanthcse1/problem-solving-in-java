package examples.daily.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLaddersSolver {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int idx = 0;
        boolean leftToRight = true;

        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    arr[idx++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    arr[idx++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }

        int[] dist = new int[n * n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == n * n - 1) return dist[curr];

            for (int move = 1; move <= 6; move++) {
                int next = curr + move;
                if (next < n * n) {
                    if (arr[next] != -1) next = arr[next] - 1;
                    if (dist[next] == -1) {
                        dist[next] = dist[curr] + 1;
                        queue.offer(next);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SnakesAndLaddersSolver solver = new SnakesAndLaddersSolver();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println("Minimum moves: " + solver.snakesAndLadders(board)); // Expected: 4
    }
}
