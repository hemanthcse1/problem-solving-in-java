package examples.daily.july;

public class MeetingRescheduler {

    public static void main(String[] args) {
        int eventTime = 10;
        int[] startTime = {1, 4, 7};
        int[] endTime = {3, 5, 8};

        MeetingRescheduler meetingRescheduler = new MeetingRescheduler();
        int result = meetingRescheduler.maxFreeTime(eventTime, startTime, endTime);
        System.out.println("Maximum Free Time: " + result);
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = getGaps(eventTime, startTime, endTime);
        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];
        int maxFree = 0;

        maxLeft[0] = gaps[0];
        for (int i = 1; i <= n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }

        maxRight[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }

        for (int i = 0; i < n; i++) {
            int meetingDuration = endTime[i] - startTime[i];
            int combinedGap = gaps[i] + gaps[i + 1];

            int leftMax = (i > 0) ? maxLeft[i - 1] : 0;
            int rightMax = (i + 2 <= n) ? maxRight[i + 2] : 0;

            boolean canMove = meetingDuration <= Math.max(leftMax, rightMax);
            int totalFree = combinedGap + (canMove ? meetingDuration : 0);
            maxFree = Math.max(maxFree, totalFree);
        }

        return maxFree;
    }

    private int[] getGaps(int eventTime, int[] start, int[] end) {
        int n = start.length;
        int[] gaps = new int[n + 1];
        gaps[0] = start[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = start[i] - end[i - 1];
        }
        gaps[n] = eventTime - end[n - 1];
        return gaps;
    }
}
