package examples.interviewquestions.strings.easy;

public class ValidWordsCounter {

    public static int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split("\\s+");
        int validWordCount = 0;

        for (String token : tokens) {
            if (isValidWord(token)) {
                validWordCount++;
            }
        }

        return validWordCount;
    }

    private static boolean isValidWord(String token) {
        int hyphenCount = 0;
        int punctuationCount = 0;
        int length = token.length();

        for (int i = 0; i < length; i++) {
            char c = token.charAt(i);

            if (Character.isDigit(c)) {
                return false;
            } else if (c == '-') {
                hyphenCount++;
                if (hyphenCount > 1) {
                    return false;
                }
                if (i == 0 || i == length - 1 || !Character.isLowerCase(token.charAt(i - 1)) ||
                        !Character.isLowerCase(token.charAt(i + 1))) {
                    return false;
                }
            } else if (c == '!' || c == '.' || c == ',') {
                punctuationCount++;
                if (punctuationCount > 1 || i != length - 1) {
                    return false;
                }
            } else if (!Character.isLowerCase(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String sentence = "cat and dog";
        System.out.println(countValidWords(sentence)); // Output: 3

        sentence = "!this  1-s b8d!";
        System.out.println(countValidWords(sentence)); // Output: 0

        sentence = "alice and  bob are playing stone-game10";
        System.out.println(countValidWords(sentence)); // Output: 5

        sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
        System.out.println(countValidWords(sentence)); // Output: 6
    }
}
