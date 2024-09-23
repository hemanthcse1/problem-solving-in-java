package examples.interviewquestions.arrays.easy;

public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }

        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        DiagonalSum solution = new DiagonalSum();

        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.diagonalSum(mat1)); // Output: 25

        int[][] mat2 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(solution.diagonalSum(mat2)); // Output: 8

        int[][] mat3 = {
                {5}
        };
        System.out.println(solution.diagonalSum(mat3)); // Output: 5
    }
}
