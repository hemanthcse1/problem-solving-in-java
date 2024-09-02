package examples.interviewquestions.strings.easy;

import java.util.HashSet;
import java.util.Set;

public class CountSpecialCharacters {

    public int countSpecialLetters(String word) {
        Set<Character> lowerCaseSet = new HashSet<>();
        Set<Character> upperCaseSet = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseSet.add(c);
            } else if (Character.isUpperCase(c)) {
                upperCaseSet.add(c);
            }
        }

        int specialCount = 0;
        for (char c : lowerCaseSet) {
            if (upperCaseSet.contains(Character.toUpperCase(c))) {
                specialCount++;
            }
        }

        return specialCount;
    }

    public static void main(String[] args) {
        CountSpecialCharacters solution = new CountSpecialCharacters();

        System.out.println(solution.countSpecialLetters("aAbBcC"));
    }
}
