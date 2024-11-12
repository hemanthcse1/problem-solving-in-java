package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false;
            }
        }

        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                int overlapStart = Math.max(start, booking[0]);
                int overlapEnd = Math.min(end, booking[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        bookings.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }

}
