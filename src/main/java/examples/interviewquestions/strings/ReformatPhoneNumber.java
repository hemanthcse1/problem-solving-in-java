package examples.interviewquestions.strings;

public class ReformatPhoneNumber {
    public static void main(String[] args) {
        String number = "1-23-45 6";
        String reformattedNumber = reformatNumber(number);
        System.out.println("Reformatted Number: " + reformattedNumber);
    }

    public static String reformatNumber(String number) {
        String cleanedNumber = number.replaceAll("[\\s-]", "");

        StringBuilder reformatted = new StringBuilder();
        int length = cleanedNumber.length();
        int i = 0;

        while (length > 4) {
            reformatted.append(cleanedNumber.substring(i, i + 3)).append("-");
            i += 3;
            length -= 3;
        }

        if (length == 4) {
            reformatted.append(cleanedNumber.substring(i, i + 2)).append("-");
            reformatted.append(cleanedNumber.substring(i + 2, i + 4));
        } else {
            reformatted.append(cleanedNumber.substring(i));
        }

        return reformatted.toString();
    }
}
