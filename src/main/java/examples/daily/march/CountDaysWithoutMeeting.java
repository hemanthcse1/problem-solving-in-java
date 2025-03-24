package examples.daily.march;

import java.util.Arrays;

public class CountDaysWithoutMeeting {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int occupied = 0;
        int prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > prevEnd) {
                occupied += end - start + 1;
                prevEnd = end;
            } else if (end > prevEnd) {
                occupied += end - prevEnd;
                prevEnd = end;
            }
        }

        return days - occupied;
    }

    public static void main(String[] args) {
        CountDaysWithoutMeeting sol = new CountDaysWithoutMeeting();

        int days1 = 10;
        int[][] meetings1 = {{5,7},{1,3},{9,10}};
        System.out.println(sol.countDays(days1, meetings1)); //  2

        int days2 = 5;
        int[][] meetings2 = {{2,4},{1,3}};
        System.out.println(sol.countDays(days2, meetings2)); //  1

        int days3 = 6;
        int[][] meetings3 = {{1,6}};
        System.out.println(sol.countDays(days3, meetings3)); //  0
    }
}
