package examples.interviewquestions.strings.easy;

public class RemoveTrailingZeros {
    public static String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i + 1);
    }

    public static void main(String[] args) {

        String num1 = "51230100";

        System.out.println(removeTrailingZeros(num1));
    }
}
