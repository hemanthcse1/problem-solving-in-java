package examples.interviewquestions.strings.easy;

public class ReplaceDigitsWithCharacters {
    public static String replaceDigits(String s) {
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i += 2) {
            char letter = chars[i - 1];
            int shiftValue = chars[i] - '0';
            chars[i] = (char) (letter + shiftValue);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "a1c1e1";
        System.out.println("Original String: " + s);
        String result = replaceDigits(s);
        System.out.println("String after replacement: " + result);
    }
}
