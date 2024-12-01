package examples.interviewquestions.strings.medium;

public class MinimumDeletions {

    public int minimumDeletions(String s) {
        int totalA = 0, countB = 0, minDeletions = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA++;
            }
        }

        int remainingA = totalA;
        minDeletions = remainingA;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                remainingA--;
            } else {
                countB++;
            }
            minDeletions = Math.min(minDeletions, countB + remainingA);
        }

        return Math.min(minDeletions, countB);
    }

    public static void main(String[] args) {
        MinimumDeletions solution = new MinimumDeletions();

        String s1 = "aababbab";
        System.out.println("Output 1: " + solution.minimumDeletions(s1));

        String s2 = "bbaaaaabb";
        System.out.println("Output 2: " + solution.minimumDeletions(s2));

    }
}
