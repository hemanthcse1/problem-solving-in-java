package examples.daily.july;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MostBookedMeetingRoomFinder {

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {
                {0, 10},
                {1, 5},
                {2, 7},
                {3, 4}
        };

        MostBookedMeetingRoomFinder finder = new MostBookedMeetingRoomFinder();
        int result = finder.mostBooked(n, meetings);
        System.out.println("Most booked room: " + result);
    }

    public int mostBooked(int n, int[][] meetings) {
        record RoomUsage(long endTime, int roomId) {}
        int[] count = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<RoomUsage> occupied = new PriorityQueue<>(Comparator.comparingLong(RoomUsage::endTime).thenComparingInt(RoomUsage::roomId));
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!occupied.isEmpty() && occupied.peek().endTime <= start)
                available.offer(occupied.poll().roomId);
            if (available.isEmpty()) {
                RoomUsage t = occupied.poll();
                count[t.roomId]++;
                occupied.offer(new RoomUsage(t.endTime + (end - start), t.roomId));
            } else {
                int roomId = available.poll();
                count[roomId]++;
                occupied.offer(new RoomUsage(end, roomId));
            }
        }
        int max = 0;
        for (int i = 1; i < n; i++)
            if (count[i] > count[max]) max = i;
        return max;
    }
}
