package examples.hashtables.easy;

import java.util.HashSet;
import java.util.Set;

public class SecondLargestDigitInString {

    public static void main(String[] args) {
        String s1 = "dfa12321afd";
        System.out.println("Second largest digit: " + secondHighest(s1));

        String s2 = "abc1111";
        System.out.println("Second largest digit: " + secondHighest(s2));

        String s3 = "abc92156def";
        System.out.println("Second largest digit: " + secondHighest(s3));
    }

    public static int secondHighest(String s) {
        Set<Integer> digits = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(ch - '0');
            }
        }

        if (digits.size() < 2) {
            return -1;
        }

        int largest = -1, secondLargest = -1;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }
        }

        return secondLargest;
    }

}
