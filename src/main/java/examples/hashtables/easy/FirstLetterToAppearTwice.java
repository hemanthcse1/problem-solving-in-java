package examples.hashtables.easy;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        return '\0';
    }

    public static void main(String[] args) {
        FirstLetterToAppearTwice solution = new FirstLetterToAppearTwice();

        String s1 = "abccbaacz";
        System.out.println(solution.repeatedCharacter(s1));

        String s2 = "abcdd";
        System.out.println(solution.repeatedCharacter(s2));
    }
}
