package examples.daily.july;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxEventsAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, res = 0;
        int n = events.length;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }

            day++;
        }

        return res;
    }

    public static void main(String[] args) {
        MaxEventsAttended solution = new MaxEventsAttended();
        int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        System.out.println(solution.maxEvents(events));
    }
}
