package examples.interviewquestions.enumerations.easy;

import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLetter {
    public static String greatestLetter(String s) {
        Set<Character> letters = new HashSet<>();
        char greatest = 0;

        for (char c : s.toCharArray()) {
            letters.add(c);
        }

        for (char c = 'Z'; c >= 'A'; c--) {
            if (letters.contains(c) && letters.contains(Character.toLowerCase(c))) {
                greatest = c;
                break;
            }
        }

        return greatest == 0 ? "" : String.valueOf(greatest);
    }

    public static void main(String[] args) {
        String s1 = "lEeTcOdE";

        System.out.println(greatestLetter(s1));
    }
}
