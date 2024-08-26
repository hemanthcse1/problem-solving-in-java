package examples.interviewquestions.strings.easy;

import java.time.LocalDate;

public class DayOfYear {
    public static int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }

    public static void main(String[] args) {
        // Example usage:
        String date = "2024-08-26";
        int dayOfYear = dayOfYear(date);
        System.out.println("Day of the year: " + dayOfYear);
    }
}
