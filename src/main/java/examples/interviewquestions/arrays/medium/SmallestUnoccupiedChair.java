package examples.interviewquestions.arrays.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[][] timesWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            timesWithIndex[i][0] = times[i][0];
            timesWithIndex[i][1] = times[i][1];
            timesWithIndex[i][2] = i;
        }

        Arrays.sort(timesWithIndex, Comparator.comparingInt(a -> a[0]));

        for (int[] time : timesWithIndex) {
            int arrival = time[0];
            int leaving = time[1];
            int friend = time[2];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                availableChairs.add(occupiedChairs.poll()[1]);
            }

            int chair = availableChairs.poll();
            if (friend == targetFriend) {
                return chair;
            }

            occupiedChairs.add(new int[]{leaving, chair});
        }

        return -1;
    }

    public static void main(String[] args) {
        SmallestUnoccupiedChair solution = new SmallestUnoccupiedChair();

        int[][] times1 = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend1 = 1;
        System.out.println(solution.smallestChair(times1, targetFriend1));

        int[][] times2 = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend2 = 0;
        System.out.println(solution.smallestChair(times2, targetFriend2));
    }
}
