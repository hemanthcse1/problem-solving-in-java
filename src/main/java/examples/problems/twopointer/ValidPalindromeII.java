package examples.problems.twopointer;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();

        System.out.println(validPalindromeII.validPalindrome("aba"));
        System.out.println(validPalindromeII.validPalindrome("abca"));
        System.out.println(validPalindromeII.validPalindrome("abc"));
    }
}
