package examples.daily.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeToReachLastRoom {
    public int minTimeToReach(int[][] moveTime) {
        return dijkstra(moveTime);
    }

    private int dijkstra(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.time));
        pq.offer(new Node(0, 0, 0)); // row, col, time

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int i = current.row;
            int j = current.col;
            int t = current.time;

            if (i == m - 1 && j == n - 1) return t;
            if (t > dist[i][j]) continue;

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;

                int moveCost = ((i + j) % 2 == 0) ? 1 : 2;
                int arrivalTime = Math.max(t, moveTime[ni][nj]) + moveCost;

                if (arrivalTime < dist[ni][nj]) {
                    dist[ni][nj] = arrivalTime;
                    pq.offer(new Node(ni, nj, arrivalTime));
                }
            }
        }

        return -1;
    }

    static class Node {
        int row, col, time;
        Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        MinimumTimeToReachLastRoom sol = new MinimumTimeToReachLastRoom();

        int[][] moveTime1 = {{0, 4}, {4, 4}};
        System.out.println(sol.minTimeToReach(moveTime1)); // 7

        int[][] moveTime2 = {{0, 0, 0, 0}, {0, 0, 0, 0}};
        System.out.println(sol.minTimeToReach(moveTime2)); // 6

        int[][] moveTime3 = {{0, 1}, {1, 2}};
        System.out.println(sol.minTimeToReach(moveTime3)); // 4
    }
}
