package examples.interviewquestions.strings.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicallySmallestString {
    public static String smallestStringAfterSwap(String s) {
        List<Character> evens = new ArrayList<>();
        List<Character> odds = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                evens.add(c);
            } else {
                odds.add(c);
            }
        }

        Collections.sort(evens);
        Collections.sort(odds);

        StringBuilder result = new StringBuilder();
        int evenIndex = 0, oddIndex = 0;

        for (char c : s.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                result.append(evens.get(evenIndex++));
            } else {
                result.append(odds.get(oddIndex++));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "4321";
        System.out.println("Lexicographically smallest string: " + smallestStringAfterSwap(s));
    }
}
