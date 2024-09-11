package examples.interviewquestions.strings.easy;

public class DateToBinary {
    public static String convertDateToBinary(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        String binaryYear = Integer.toBinaryString(year);
        String binaryMonth = Integer.toBinaryString(month);
        String binaryDay = Integer.toBinaryString(day);

        return binaryYear + "-" + binaryMonth + "-" + binaryDay;
    }

    public static void main(String[] args) {
        String date = "2024-09-06";
        System.out.println("Binary representation of date: " + convertDateToBinary(date));
    }
}
