package examples.interviewquestions.strings.easy;

public class ValidWord {
    public static boolean isValidWord(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }

            if (isVowel(c)) {
                hasVowel = true;
            }

            else if (Character.isLetter(c)) {
                hasConsonant = true;
            }
            if (hasVowel && hasConsonant) {
                return true;
            }
        }

        return hasVowel && hasConsonant;
    }

    private static boolean isVowel(char c) {
        char lowerC = Character.toLowerCase(c);
        return lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u';
    }

    public static void main(String[] args) {
        String word1 = "Hello";
        String word2 = "123";
        String word3 = "ab1";

        System.out.println("Is 'Hello' a valid word? " + isValidWord(word1));
        System.out.println("Is '123' a valid word? " + isValidWord(word2));
        System.out.println("Is 'ab1' a valid word? " + isValidWord(word3));
    }
}
