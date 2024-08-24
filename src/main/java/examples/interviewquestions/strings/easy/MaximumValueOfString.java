package examples.interviewquestions.strings.easy;

public class MaximumValueOfString {
    public static void main(String[] args) {
        String[] strs = {"123", "abc", "a1b2c3", "4567", "789"};
        System.out.println(maximumValue(strs));
    }
    public static int maximumValue(String[] strs) {
        int maxValue = 0;
        for (String str : strs) {
            int value = 0;
            if (isNumeric(str)) {
                value = Integer.parseInt(str);
            } else {
                value = str.length();
            }
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }
    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
