package examples.interviewquestions.strings;

public class StringScore {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println("String score "+stringScore(s));
    }

    public static int stringScore(String s) {
        int stringScore = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            int score = Math.abs(s.charAt(i) - s.charAt(i + 1));

            stringScore += score;
        }
        return stringScore;
    }
}
