package examples.interviewquestions.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        backtrack(result, digits, "", 0);

        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }

        char digit = digits.charAt(index);

        String letters = KEYPAD[digit - '0'];

        for (char letter : letters.toCharArray()) {
            backtrack(result, digits, current + letter, index + 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber solution = new LetterCombinationOfPhoneNumber();

        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("2"));
    }
}
