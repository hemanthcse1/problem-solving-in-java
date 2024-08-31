package examples.interviewquestions.enumerations.easy;

public class LatestTime {
    public static String maximumTime(String s) {
        StringBuilder time = new StringBuilder(s);
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?' || time.charAt(1) <= '1') {
                time.setCharAt(0, '1');
            } else {
                time.setCharAt(0, '0');
            }
        }

        if (time.charAt(1) == '?') {
            if (time.charAt(0) == '1') {
                time.setCharAt(1, '1');
            } else {
                time.setCharAt(1, '9');
            }
        }

        if (time.charAt(3) == '?') {
            time.setCharAt(3, '5');
        }

        if (time.charAt(4) == '?') {
            time.setCharAt(4, '9');
        }

        return time.toString();
    }

    public static void main(String[] args) {
        System.out.println(maximumTime("1?:?9"));
        System.out.println(maximumTime("0?:3?"));
        System.out.println(maximumTime("??:??"));
        System.out.println(maximumTime("?2:45"));
    }
}
