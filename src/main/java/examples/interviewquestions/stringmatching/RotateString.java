package examples.interviewquestions.stringmatching;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String concatenated = s + s;

        return concatenated.contains(goal);
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        System.out.println(rs.rotateString("abcde", "cdeab"));
        System.out.println(rs.rotateString("abcde", "abced"));
    }
}
