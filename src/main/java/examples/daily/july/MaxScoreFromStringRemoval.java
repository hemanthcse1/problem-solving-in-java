package examples.daily.july;

public class MaxScoreFromStringRemoval {

    public static void main(String[] args) {
        MaxScoreFromStringRemoval solution = new MaxScoreFromStringRemoval();

        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;

        int result = solution.maximumGain(s, x, y);
        System.out.println("Maximum Score: " + result);
    }

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
}
