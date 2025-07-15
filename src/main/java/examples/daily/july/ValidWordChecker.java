package examples.daily.july;

public class ValidWordChecker {
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false; // Invalid character
            }

            if (isVowel(ch)) {
                hasVowel = true;
            } else if (Character.isLetter(ch)) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public static void main(String[] args) {
        ValidWordChecker checker = new ValidWordChecker();
        System.out.println(checker.isValid("234Adas")); // true
        System.out.println(checker.isValid("b3"));       // false
        System.out.println(checker.isValid("a3$e"));     // false
    }
}
