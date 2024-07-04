package examples.interviewquestions.slidingwindow;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] charCountT = new int[128]; // Character counts for string t
        for (char c : t.toCharArray()) {
            charCountT[c]++;
        }

        int left = 0;
        int right = 0;
        int minWindowStart = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int count = 0; // Number of characters from t found in the current window

        while (right < s.length()) {
            char c = s.charAt(right);
            if (charCountT[c] > 0) {
                count++; // Increment count if character is present in t
            }

            while (count == t.length()) { // Window contains all characters from t
                char leftmostChar = s.charAt(left);
                if (right - left + 1 < minWindowLength) { // Update minWindow
                    minWindowStart = left;
                    minWindowLength = right - left + 1;
                }

                if (charCountT[leftmostChar] > 0) {
                    count--; // Decrement count if character is leaving the window
                }
                left++;
            }

            right++;
        }

        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindow = minWindow(s, t);
        System.out.println("Minimum window substring containing all characters of '" + t + "': " + minWindow);
    }
}
