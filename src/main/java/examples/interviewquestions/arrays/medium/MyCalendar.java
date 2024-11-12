package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    private List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] booking : bookings) {
            int bookedStart = booking[0];
            int bookedEnd = booking[1];
            if (start < bookedEnd && end > bookedStart) {
                return false;
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
