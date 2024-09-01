package examples.interviewquestions.strings.easy;

public class DigitSumOfString {
    public static String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < i + k && j < s.length(); j++) {
                    sum += s.charAt(j) - '0';
                }
                newString.append(sum);
            }
            s = newString.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(digitSum("1111122222", 3));
        System.out.println(digitSum("1234", 2));
        System.out.println(digitSum("987654321", 4));
    }
}
