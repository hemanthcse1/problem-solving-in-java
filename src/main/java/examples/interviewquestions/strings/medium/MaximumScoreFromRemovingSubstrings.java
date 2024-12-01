package examples.interviewquestions.strings.medium;

public class MaximumScoreFromRemovingSubstrings {

    public int maximumGain(String s, int x, int y) {
        int score = 0;

        StringBuilder sb = new StringBuilder(s);
        score += removeSubstring(sb, x > y ? 'a' : 'b', x > y ? 'b' : 'a', Math.max(x, y));
        score += removeSubstring(sb, x > y ? 'b' : 'a', x > y ? 'a' : 'b', Math.min(x, y));

        return score;
    }

    private int removeSubstring(StringBuilder s, char first, char second, int points) {
        StringBuilder stack = new StringBuilder();
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == first && ch == second) {
                stack.deleteCharAt(stack.length() - 1);
                score += points;
            } else {
                stack.append(ch);
            }
        }

        s.setLength(0);
        s.append(stack);

        return score;
    }

    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings solution = new MaximumScoreFromRemovingSubstrings();
        String s1 = "cdbcbbaaabab";
        int x1 = 4, y1 = 5;
        System.out.println("Output 1: " + solution.maximumGain(s1, x1, y1)); // Output: 19

        String s2 = "aabbaaxybbaabb";
        int x2 = 5, y2 = 4;
        System.out.println("Output 2: " + solution.maximumGain(s2, x2, y2)); // Output: 20
    }
}
