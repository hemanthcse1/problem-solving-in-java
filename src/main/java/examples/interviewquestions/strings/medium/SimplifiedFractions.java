package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();

        for (int denominator = 2; denominator <= n; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    result.add(numerator + "/" + denominator);
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        SimplifiedFractions sf = new SimplifiedFractions();

        System.out.println(sf.simplifiedFractions(2));
        System.out.println(sf.simplifiedFractions(3));
        System.out.println(sf.simplifiedFractions(4));
    }
}
