package examples.interviewquestions.strings.easy;

public class RemoveDigitToMaximize {

    public String removeDigit(String number, char digit) {
        String maxResult = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String newNumber = number.substring(0, i) + number.substring(i + 1);

                if (newNumber.compareTo(maxResult) > 0) {
                    maxResult = newNumber;
                }
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        RemoveDigitToMaximize solution = new RemoveDigitToMaximize();

        System.out.println(solution.removeDigit("1231", '1'));
        System.out.println(solution.removeDigit("551", '5'));
        System.out.println(solution.removeDigit("765543", '5'));
    }
}
