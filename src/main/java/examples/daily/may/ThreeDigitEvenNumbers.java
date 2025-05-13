package examples.daily.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeDigitEvenNumbers {

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k && digits[i] != 0 && digits[k] % 2 == 0) {
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        uniqueNumbers.add(number);
                    }
                }
            }
        }

        int[] result = uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] digits1 = {2, 1, 3, 0};
        System.out.println(Arrays.toString(findEvenNumbers(digits1)));

        int[] digits2 = {2, 2, 8, 8, 2};
        System.out.println(Arrays.toString(findEvenNumbers(digits2)));

        int[] digits3 = {3, 7, 5};
        System.out.println(Arrays.toString(findEvenNumbers(digits3)));
    }
}
