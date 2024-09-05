package examples.interviewquestions.strings.easy;

public class CountDaysTogether {

    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrive = convertToDayOfYear(arriveAlice);
        int aliceLeave = convertToDayOfYear(leaveAlice);
        int bobArrive = convertToDayOfYear(arriveBob);
        int bobLeave = convertToDayOfYear(leaveBob);

        int maxArrive = Math.max(aliceArrive, bobArrive);
        int minLeave = Math.min(aliceLeave, bobLeave);

        if (maxArrive <= minLeave) {
            return minLeave - maxArrive + 1;
        }
        return 0;
    }

    private int convertToDayOfYear(String date) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        return dayOfYear + day;
    }

    public static void main(String[] args) {
        CountDaysTogether solution = new CountDaysTogether();


        System.out.println(solution.countDaysTogether("08-15", "08-18", "08-16", "08-19"));  // Output: 3
        System.out.println(solution.countDaysTogether("10-01", "10-31", "11-01", "12-31"));  // Output: 0
        System.out.println(solution.countDaysTogether("09-01", "09-30", "09-15", "10-15"));  // Output: 16
    }
}
