package examples.interviewquestions.arrays.medium;

public class CountSquare {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    count += dp[i][j];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountSquare count = new CountSquare();

        int[][] matrix1 = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(count.countSquares(matrix1));  // Output: 15

        int[][] matrix2 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(count.countSquares(matrix2));  // Output: 7
    }
}
