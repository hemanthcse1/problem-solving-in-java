package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class SumOfMatrixRowColumns {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= result[i][j];
                colSum[j] -= result[i][j];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        SumOfMatrixRowColumns solution = new SumOfMatrixRowColumns();


        int[] rowSum1 = {3, 8};
        int[] colSum1 = {4, 7};
        int[][] result1 = solution.restoreMatrix(rowSum1, colSum1);
        System.out.println("Matrix for Example 1:");
        printMatrix(result1);

        int[] rowSum2 = {5, 7, 10};
        int[] colSum2 = {8, 6, 8};
        int[][] result2 = solution.restoreMatrix(rowSum2, colSum2);
        System.out.println("Matrix for Example 2:");
        printMatrix(result2);


        int[] rowSum3 = {14, 9};
        int[] colSum3 = {6, 14, 3};
        int[][] result3 = solution.restoreMatrix(rowSum3, colSum3);
        System.out.println("Matrix for Example 3:");
        printMatrix(result3);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
