package examples.daily.may;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DungeonPathFinder {

    public static void main(String[] args) {
        DungeonPathFinder solution = new DungeonPathFinder();

        int[][] moveTime1 = {{0, 4}, {4, 4}};
        int[][] moveTime2 = {{0, 0, 0}, {0, 0, 0}};
        int[][] moveTime3 = {{0, 1}, {1, 2}};

        System.out.println("Test Case 1 Output: " + solution.minTimeToReach(moveTime1)); // Expected: 6
        System.out.println("Test Case 2 Output: " + solution.minTimeToReach(moveTime2)); // Expected: 3
        System.out.println("Test Case 3 Output: " + solution.minTimeToReach(moveTime3)); // Expected: 3
    }

    public int minTimeToReach(int[][] moveTime) {
        return dijkstra(moveTime, 0, 0,
                moveTime.length - 1, moveTime[0].length - 1);
    }

    private int dijkstra(int[][] moveTime, int srcX, int srcY, int dstX, int dstY) {
        final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = moveTime.length;
        final int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        dist[srcX][srcY] = 0;

        Queue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        minHeap.offer(new Node(srcX, srcY, 0));

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            int x = curr.x, y = curr.y, d = curr.time;

            if (x == dstX && y == dstY)
                return d;

            if (d > dist[x][y])
                continue;

            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                int newDist = Math.max(moveTime[nx][ny], d) + 1;

                if (newDist < dist[nx][ny]) {
                    dist[nx][ny] = newDist;
                    minHeap.offer(new Node(nx, ny, newDist));
                }
            }
        }

        return -1;
    }

    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
