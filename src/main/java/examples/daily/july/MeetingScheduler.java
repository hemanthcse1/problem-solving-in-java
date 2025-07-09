package examples.daily.july;

public class MeetingScheduler {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int windowSum = 0, maxSum = 0;
        for (int i = 0; i <= k && i < gaps.length; i++) {
            windowSum += gaps[i];
        }
        maxSum = windowSum;

        for (int i = k + 1; i < gaps.length; i++) {
            windowSum += gaps[i] - gaps[i - k - 1];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();

        int eventTime1 = 5, k1 = 1;
        int[] startTime1 = {1, 3};
        int[] endTime1 = {2, 5};
        System.out.println(scheduler.maxFreeTime(eventTime1, k1, startTime1, endTime1)); // 2

        int eventTime2 = 10, k2 = 1;
        int[] startTime2 = {0, 2, 9};
        int[] endTime2 = {1, 4, 10};
        System.out.println(scheduler.maxFreeTime(eventTime2, k2, startTime2, endTime2)); // 6

        int eventTime3 = 5, k3 = 2;
        int[] startTime3 = {0, 1, 2, 3, 4};
        int[] endTime3 = {1, 2, 3, 4, 5};
        System.out.println(scheduler.maxFreeTime(eventTime3, k3, startTime3, endTime3)); // 0
    }
}
