package examples.interviewquestions.strings.easy;

public class ValidClockTimes {
    public static int countValidTimes(String time) {
        int count = 1;

        if (time.charAt(0) == '?') {
            count *= (time.charAt(1) == '?' || time.charAt(1) <= '3') ? 3 : 2;
        }

        if (time.charAt(1) == '?') {
            count *= (time.charAt(0) == '2') ? 4 : 10;
        }

        if (time.charAt(3) == '?') {
            count *= 6; // '0'-'5'
        }

        if (time.charAt(4) == '?') {
            count *= 10; // '0'-'9'
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage:
        String time = "??:??";
        int validTimes = countValidTimes(time);
        System.out.println("Number of valid times: " + validTimes);
    }
}
