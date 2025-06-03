package examples.daily.june;

import java.util.ArrayDeque;
import java.util.Queue;

public class CandyBoxCollector {
    public static void main(String[] args) {
        CandyBoxCollector candyBoxCollector = new CandyBoxCollector();

        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = {{}, {}, {1}, {}};
        int[][] containedBoxes = {{1, 2}, {3}, {}, {}};
        int[] initialBoxes = {0};

        int result = candyBoxCollector.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println("Maximum candies collected: " + result);
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
                          int[] initialBoxes) {
        int totalCandies = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[status.length];

        for (int box : initialBoxes) {
            if (status[box] == 1) {
                queue.offer(box);
            } else {
                visited[box] = true;
            }
        }

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            for (int key : keys[box]) {
                if (status[key] == 0 && visited[key]) {
                    queue.offer(key);
                }
                status[key] = 1;
            }

            for (int nextBox : containedBoxes[box]) {
                if (status[nextBox] == 1) {
                    queue.offer(nextBox);
                } else {
                    visited[nextBox] = true;
                }
            }
        }

        return totalCandies;
    }
}
