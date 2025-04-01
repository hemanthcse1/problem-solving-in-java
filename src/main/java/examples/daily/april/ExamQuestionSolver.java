package examples.daily.april;

public class ExamQuestionSolver {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skip = questions[i][1];
            int nextIndex = i + skip + 1;
            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);
            long dontSolve = dp[i + 1];
            dp[i] = Math.max(solve, dontSolve);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        ExamQuestionSolver solver = new ExamQuestionSolver();

        int[][] questions1 = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(solver.mostPoints(questions1)); //  5

        int[][] questions2 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(solver.mostPoints(questions2)); //  7
    }
}
