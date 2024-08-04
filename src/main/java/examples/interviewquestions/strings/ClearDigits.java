package examples.interviewquestions.strings;

public class ClearDigits {
    public static void main(String[] args) {
        String s = "ab3c4d2e";
        String result = clearDigits(s);
        System.out.println("Resulting String: " + result);
    }

    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);

        while (true) {
            int digitIndex = findFirstDigitIndex(sb);
            if (digitIndex == -1) {
                break;
            }

            int closestNonDigitIndex = findClosestNonDigitIndex(sb, digitIndex);

            sb.deleteCharAt(digitIndex);
            if (closestNonDigitIndex != -1) {
                sb.deleteCharAt(closestNonDigitIndex);
            }
        }

        return sb.toString();
    }

    private static int findFirstDigitIndex(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private static int findClosestNonDigitIndex(StringBuilder sb, int digitIndex) {
        for (int i = digitIndex - 1; i >= 0; i--) {
            if (!Character.isDigit(sb.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
