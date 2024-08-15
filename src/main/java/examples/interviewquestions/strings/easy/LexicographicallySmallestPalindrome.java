package examples.interviewquestions.strings.easy;

public class LexicographicallySmallestPalindrome {
    public static String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;

            if (chars[i] != chars[j]) {
                char smallerChar = (char) Math.min(chars[i], chars[j]);
                chars[i] = smallerChar;
                chars[j] = smallerChar;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "egcfe";
        System.out.println("Original String: " + s);
        String result = makeSmallestPalindrome(s);
        System.out.println("Lexicographically Smallest Palindrome: " + result);
    }
}
