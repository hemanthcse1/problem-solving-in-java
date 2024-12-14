package examples.interviewquestions.strings.medium;

public class LongestSemiRepetitiveSubstringFinder {

    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int left = 0;
        int pairs = 0;
        int maxLength = 1;

        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                pairs++;
            }
            while (pairs > 1) {
                if (s.charAt(left + 1) == s.charAt(left)) {
                    pairs--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSemiRepetitiveSubstringFinder finder = new LongestSemiRepetitiveSubstringFinder();
        String s1 = "52233";
        System.out.println(finder.longestSemiRepetitiveSubstring(s1));

        String s2 = "5494";
        System.out.println(finder.longestSemiRepetitiveSubstring(s2));

        String s3 = "1111111";
        System.out.println(finder.longestSemiRepetitiveSubstring(s3));
    }
}
