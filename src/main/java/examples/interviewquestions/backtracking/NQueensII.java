package examples.interviewquestions.backtracking;

public class NQueensII {
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        solve(0, n, cols, diag1, diag2);
        return count;
    }

    private void solve(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            cols[col] = diag1[d1] = diag2[d2] = true;
            solve(row + 1, n, cols, diag1, diag2);
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    public static void main(String[] args) {
        NQueensII solution = new NQueensII();
        System.out.println(solution.totalNQueens(4)); //  2
        System.out.println(solution.totalNQueens(1)); //  1
    }
}
