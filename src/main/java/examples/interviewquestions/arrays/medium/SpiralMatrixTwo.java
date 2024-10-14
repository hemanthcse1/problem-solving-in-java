package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (value <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixTwo solution = new SpiralMatrixTwo();

        int n1 = 3;
        int[][] result1 = solution.generateMatrix(n1);
        System.out.println("Output for n = 3:");
        printMatrix(result1);

        int n2 = 1;
        int[][] result2 = solution.generateMatrix(n2);
        System.out.println("Output for n = 1:");
        printMatrix(result2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
