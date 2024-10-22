package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n + 1];

        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            answer[first - 1] += seats;

            if (last < n) {
                answer[last] -= seats;
            }
        }

        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }

        return Arrays.copyOf(answer, n);
    }

    public static void main(String[] args) {
        CorporateFlightBookings solution = new CorporateFlightBookings();

        int[][] bookings1 = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n1 = 5;
        System.out.println(Arrays.toString(solution.corpFlightBookings(bookings1, n1)));

        int[][] bookings2 = {{1, 2, 10}, {2, 2, 15}};
        int n2 = 2;
        System.out.println(Arrays.toString(solution.corpFlightBookings(bookings2, n2)));
    }
}
