package examples.interviewquestions.strings.easy;

public class SubstringKConstraint {
    public static int countSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int start = 0; start < n; start++) {
            int zeros = 0;
            int ones = 0;

            for (int end = start; end < n; end++) {
                if (s.charAt(end) == '0') {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros <= k || ones <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "1101001";
        int k = 2;
        System.out.println("Number of substrings that satisfy the k-constraint: " + countSubstrings(s, k));
    }
}
