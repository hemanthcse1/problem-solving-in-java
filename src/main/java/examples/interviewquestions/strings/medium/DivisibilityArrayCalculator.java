package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class DivisibilityArrayCalculator {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix = (prefix * 10 + (word.charAt(i) - '0')) % m;
            div[i] = (prefix == 0) ? 1 : 0;
        }
        return div;
    }

    public static void main(String[] args) {
        DivisibilityArrayCalculator calculator = new DivisibilityArrayCalculator();
        String word = "998244353";
        int m = 3;
        int[] result = calculator.divisibilityArray(word, m);
        System.out.println(Arrays.toString(result));
    }
}
