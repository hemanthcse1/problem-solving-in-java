package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int[] minInRow = new int[m];
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            minInRow[i] = min;
        }

        int[] maxInCol = new int[n];
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxInCol[j] = max;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minInRow[i] && matrix[i][j] == maxInCol[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }

    public static void main(String[] args) {
        LuckyNumbersInMatrix solution = new LuckyNumbersInMatrix();

        int[][] matrix1 = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println("Lucky Numbers: " + solution.luckyNumbers(matrix1));

        int[][] matrix2 = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println("Lucky Numbers: " + solution.luckyNumbers(matrix2));

        int[][] matrix3 = {{7, 8}, {1, 2}};
        System.out.println("Lucky Numbers: " + solution.luckyNumbers(matrix3));
    }
}
