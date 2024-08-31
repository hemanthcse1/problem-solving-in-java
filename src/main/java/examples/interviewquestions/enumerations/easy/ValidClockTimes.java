package examples.interviewquestions.enumerations.easy;

public class ValidClockTimes {

    public static int countValidTimes(String time) {
        int validCount = 1;
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {

                validCount *= 24;
            } else if (time.charAt(1) >= '0' && time.charAt(1) <= '3') {

                validCount *= 3;
            } else {

                validCount *= 2;
            }
        } else if (time.charAt(0) == '2') {

            if (time.charAt(1) == '?') {
                validCount *= 4;
            }
        } else {

            if (time.charAt(1) == '?') {
                validCount *= 10;
            }
        }


        if (time.charAt(3) == '?') {
            validCount *= 6;
        }
        if (time.charAt(4) == '?') {
            validCount *= 10;
        }

        return validCount;
    }

    public static void main(String[] args) {
        String time1 = "2?:?0";
        String time2 = "0?:3?";
        String time3 = "1?:22";
        String time4 = "?4:5?";

        System.out.println(countValidTimes(time1));
        System.out.println(countValidTimes(time2));
        System.out.println(countValidTimes(time3));
        System.out.println(countValidTimes(time4));
    }
}
