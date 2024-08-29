package examples.interviewquestions.slidingwindow.easy;

public class LongestNiceSubstring {
    public static String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c) && s.indexOf(Character.toUpperCase(c)) == -1 ||
                    Character.isUpperCase(c) && s.indexOf(Character.toLowerCase(c)) == -1) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println("Longest Nice Substring: " + longestNiceSubstring(s));
    }
}
