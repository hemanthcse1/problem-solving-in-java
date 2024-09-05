package examples.interviewquestions.strings.easy;

public class Largest3SameDigitNumber {

    public String largestGoodInteger(String num) {
        String largestGood = "";

        for (int i = 0; i <= num.length() - 3; i++) {
            String substring = num.substring(i, i + 3);

            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)) {
                if (largestGood.isEmpty() || substring.compareTo(largestGood) > 0) {
                    largestGood = substring;
                }
            }
        }

        return largestGood;
    }

    public static void main(String[] args) {
        Largest3SameDigitNumber solution = new Largest3SameDigitNumber();

        System.out.println(solution.largestGoodInteger("6777133339"));
        System.out.println(solution.largestGoodInteger("2300019"));
        System.out.println(solution.largestGoodInteger("42352338"));
    }
}
