package examples.interviewquestions.strings.easy;

public class SumOfDigitsAfterConvert {
    public int getLucky(String s, int k) {
        StringBuilder numericString = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int value = ch - 'a' + 1;
            numericString.append(value);
        }
        String currentString = numericString.toString();
        for (int i = 0; i < k; i++) {
            currentString = sumOfDigits(currentString);
        }
        return Integer.parseInt(currentString);
    }

    private String sumOfDigits(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum += ch - '0';
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        SumOfDigitsAfterConvert solution = new SumOfDigitsAfterConvert();
        System.out.println(solution.getLucky("zbax", 2));
        System.out.println(solution.getLucky("leetcode", 2));
    }
}
